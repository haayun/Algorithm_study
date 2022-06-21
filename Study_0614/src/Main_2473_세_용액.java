import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2473_세_용액 {
	static long[] answer;
	static long[] liquid;
	static int N;
	static long min = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		liquid = new long[N];
		for (int i = 0; i < N; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(liquid);

		for (int i = 0; i < N - 2; i++) {
			mix(i);
		}
		for (long ans : answer) {
			System.out.print(ans + " ");
		}
	}

	static void mix(int idx) {
		int left = idx + 1, right = N - 1;

		while (left < right) {
			long add = liquid[idx] + liquid[left] + liquid[right];
			if(add == 0) {
				answer = new long[] {liquid[idx], liquid[left], liquid[right]};
				break;
			}
			if(Math.abs(add) < min) {
				min = Math.abs(add);
				answer = new long[] {liquid[idx], liquid[left], liquid[right]};
			}
			
			if(add > 0)
				right--;
			else if (add < 0)
				left++;
		}
	}
}

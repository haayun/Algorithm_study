

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2467_용액 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] liq = new long[N];
		for (int i = 0; i < N; i++) {
			liq[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0, right = N - 1;
		long min = Long.MAX_VALUE;
		long[] answer = new long[2];

		while (left < right) {
			long sum = liq[left] + liq[right];
			if (sum == 0) {
				answer = new long[] { liq[left], liq[right] };
				break;
			}
			if (Math.abs(sum) < min) {
				min = Math.abs(sum);
				answer = new long[] { liq[left], liq[right] };

			}

			if (sum > 0) {
				right--;
			} else {
				left++;
			}

		}
		System.out.println(answer[0] + " " + answer[1]);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2531_회전_초밥 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] belt = new int[N];
		int[] sushi = new int[d + 1];
		int cnt = 1;
		sushi[c]++;

		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
			if (i < k) {
				sushi[belt[i]]++;
				if(sushi[belt[i]] == 1) cnt++;
			}
		}

		int answer = cnt;
		int left = 0, right = k - 1;
		while (left < N) {
			
			sushi[belt[left]]--;
			if(sushi[belt[left++]] == 0) cnt--;
			
			right = (right + 1) % N;
			sushi[belt[right]]++;
			if(sushi[belt[right]] == 1) cnt++;

			answer = Math.max(answer, cnt);
		}
		System.out.println(answer);
	}
}

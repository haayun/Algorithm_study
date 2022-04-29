import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17404_RGB거리_2 {

	static int N, answer;
	static int[][] price;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		answer = Integer.MAX_VALUE;
		price = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				price[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < 3; i++)
			paint(i);

		System.out.println(answer);
	}

	static void paint(int sc) {
		int[][] dp = new int[N][3];

		dp[0][sc] = price[0][sc];
		dp[0][(sc + 1) % 3] = 1001;
		dp[0][(sc + 2) % 3] = 1001;

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				dp[i][j] = price[i][j] + Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
			}
		}

		answer = Math.min(answer, dp[N - 1][(sc + 1) % 3]);
		answer = Math.min(answer, dp[N - 1][(sc + 2) % 3]);
	}
}

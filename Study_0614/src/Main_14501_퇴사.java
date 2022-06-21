import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501_퇴사 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			board[i] = new int[] { T, P };
		}

		int[] dp = new int[N + 1];
		for (int i = N - 1; i >= 0; i--) {
			dp[i] = dp[i + 1];
			if (i + board[i][0] > N)
				continue;
			dp[i] = Math.max(dp[i], dp[i + board[i][0]] + board[i][1]);

		}

		System.out.println(dp[0]);

	}

}

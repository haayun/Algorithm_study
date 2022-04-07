import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2133_타일_채우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[31];

		// 점화식
		// dp[4] = dp[2] * 3 + dp[0] * 2 + 2;
		// dp[6] = dp[4] * 3 + dp[2] * 2 + dp[0] * 2 + 2;

		dp[0] = dp[1] = 0;
		dp[2] = 3;

		for (int i = 3; i <= N; i++) {
			if (i % 2 > 0) {
				dp[i] = 0;
				continue;
			}

			dp[i] = dp[i - 2] * 3 + 2;
			for (int j = i - 4; j >= 0; j -= 2) {
				dp[i] += dp[j] * 2;
			}
		}
		System.out.println(dp[N]);

	}

}

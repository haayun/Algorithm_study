import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10844_쉬운_계단_수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] dp = new int[N + 1][12];	// 편의상 +1, -1 고려해서 크기 12로
		int ans = 0;

		// 1의 자리 초기화 (1 ~ 9)
		for (int i = 2; i <= 10; i++)
			dp[1][i] = 1;

		for (int i = 2; i <= N; i++) { // 자릿
			for (int j = 1; j <= 10; j++) { // 끝나는 수 (0 ~ 9)
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
			}
		}

		for (int i = 1; i <= 10; i++) {
			ans = (ans + dp[N][i]) % 1000000000;
		}
		System.out.println(ans);
	}

}

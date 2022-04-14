import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1932_정수_삼각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N][];
		int[] tmp;
		
		// 입력
		for(int i = 0; i < N; i++) {
			tmp = new int[i+1];
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < i + 1; j++) {
				tmp[j] = Integer.parseInt(st.nextToken());
			}
			dp[i] = tmp;
		}
		
		// dp 연산
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i + 1; j++) {
				if(j == 0)
					dp[i][j] += dp[i-1][j];
				else if (j == i)
					dp[i][j] += dp[i-1][j-1];
				else
					dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
			}
		}
		
		// 최댓값 갱신
		int answer = 0;
		for(int i = 0; i < N; i++)
			answer = Math.max(answer, dp[N-1][i]);
		
		// 출력
		System.out.println(answer);
		
	}

}

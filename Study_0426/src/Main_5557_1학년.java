import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5557_1학년 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[][] dp = new long[N][21];	// 경우의 수가 2^63 - 1까지..
		// 첫번째 수 체크
		dp[0][Integer.parseInt(st.nextToken())] = 1;
		for(int i = 1; i < N - 1; i++) {
			int num = Integer.parseInt(st.nextToken());
			for(int j = 0; j <= 20; j++) {
				if(dp[i-1][j] == 0) continue;
			
				if(j + num <= 20) dp[i][j+num] += dp[i-1][j];	// 더했을 때 겹치는 경우
				if(j - num >= 0) dp[i][j-num] += dp[i-1][j];	// 뺐을 때 겹치는 경우
			}
		}
		// 마지막 수가 우변이 된다
		System.out.println(dp[N-2][Integer.parseInt(st.nextToken())]);
		
	}

}

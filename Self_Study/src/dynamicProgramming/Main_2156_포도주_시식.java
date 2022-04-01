package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2156_포도주_시식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] wine = new int[N+1];
		
		// 입력
		for(int i = 1; i <= N; i++)
			wine[i] = Integer.parseInt(br.readLine());
		
		// dp 연산
		int[][] dp = new int[N+1][4];
		// ox, xx, xo, oo
		// ox는 이전 oo, xo
		int[][] before = {{2, 3}, {0, 1}, {0, 1}, {2}};
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < 4; j++) {
				int max = dp[i-1][before[j][0]];
				if(j < 2) {
					dp[i][j] = Math.max(max, dp[i-1][before[j][1]]);
				} else if (j == 2) {
					dp[i][j] = Math.max(max, dp[i-1][before[j][1]]) + wine[i];					
				} else {
					dp[i][j] = max + wine[i];
				}
			}
			
		}
		
		int ans = 0;
		for(int i = 0; i < 4; i++)
			ans = Math.max(ans, dp[N][i]);
		
		// 출력
		System.out.println(ans);
	}

}

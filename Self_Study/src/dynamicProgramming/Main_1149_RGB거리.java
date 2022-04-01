package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_RGB거리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N+1][3];
		int[][] before = {{1, 2}, {0, 2}, {0, 1}};
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				dp[i][j] = Math.min(dp[i-1][before[j][0]], dp[i-1][before[j][1]]) + Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++)
			ans = Math.min(ans, dp[N][i]);
		System.out.println(ans);
	}

}

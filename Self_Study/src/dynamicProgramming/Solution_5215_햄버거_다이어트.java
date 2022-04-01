package dynamicProgramming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_햄버거_다이어트 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		int[] scores, calories, dp;
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			scores = new int[N];
			calories = new int[N];
			dp = new int[L+1];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(st.nextToken());
				calories[i] = Integer.parseInt(st.nextToken());
			}

			for(int i = 0; i < N; i++) {
				for(int j = L; j >= calories[i]; j--) {
					dp[j] = Math.max(dp[j - calories[i]] + scores[i], dp[j]);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(dp[L]).append("\n");
		}
		System.out.println(sb);
	}

}

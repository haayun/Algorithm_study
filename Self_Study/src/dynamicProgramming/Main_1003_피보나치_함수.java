package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1003_피보나치_함수 {

	static int[][] memo = new int[41][2];
	
	static int fibo(int n, int i) {
		if(n >= 2 && memo[n][i] == 0) {
			memo[n][i] = fibo(n-1, i) + fibo(n-2, i);
		}
		return memo[n][i];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		memo[0][0] = 1;
		memo[0][1] = 0;
		memo[1][0] = 0;
		memo[1][1] = 1;
		
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(fibo(n, 0)).append(" ").append(fibo(n, 1)).append("\n");
		}
		System.out.println(sb);
		
	}

}

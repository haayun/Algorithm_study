package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9095_123_더하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		int[] memo = new int[11];
		
		memo[1] = 1;
		memo[2] = 2;
		memo[3] = 4;
		
		for(int i = 4; i < 11; i++) {
			memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
		}
		
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(memo[n]);
		}
	}

}

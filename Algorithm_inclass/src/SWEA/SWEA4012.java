package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA4012 {


	static int N, R;
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int[][] synergy;
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); R = N/2;
			synergy = new int[N][N];
			// 입력 
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j= 0; j<N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			p = new int[N];
			int cnt = 0;
			while(++cnt <= R) p[N-cnt] = 1;
			
			int ans = Integer.MAX_VALUE;
			do {
			
				int half_1 = 0, half_2 = 0;
				
				for(int i =0; i <N; i++) {
					for(int j = 0; j <N; j++) {
						if(p[i] == 1 && p[j] == 1) {
							half_1 += synergy[i][j];
						}
						else if (p[i] == 0 && p[j] == 0) {
							half_2 += synergy[i][j];							
						}
					}
				}
//				System.out.println(half_1 +" "+ half_2);
				ans = Math.min(ans, Math.abs(half_1 - half_2));
				
			}while(np() && p[0] == 0);
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);
			
	}
	
	static boolean np() {
		int i = N-1;
		while(i > 0 && p[i-1] >= p[i]) --i;
		if(i == 0) return false;
		
		int j = N-1;
		while(p[i-1] >= p[j]) --j;
		
		swap(i-1, j);
		
		int k = N-1;
		while(i < k) swap(i++, k--);
		
		return true;
	}
	static void swap(int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}
}

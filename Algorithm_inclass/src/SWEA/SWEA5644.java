package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 실행시간 : 127 ms
 * 메모리 : 22,860 kb
 */

public class SWEA5644 {
	static class BC{
		public int x, y, c, p;
		public BC(int x, int y, int c, int p){
			this.x = x; this.y = y; this.c = c; this.p = p;
		}
		boolean inCoverage(int row, int col) {
			if((Math.abs(row - x) + Math.abs(col - y)) <= c)
				return true;
			return false;
		}
	}
	
	static int[][] d = {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int M, A;
	static BC[] chargers;
	static int a_r, a_c, b_r, b_c;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] d_a, d_b;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); A = Integer.parseInt(st.nextToken());
			d_a = new int[M]; d_b = new int[M]; chargers = new BC[A];
			a_r = 1; a_c = 1; b_r = 10; b_c = 10;
			
			// 입력 
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++)
				d_a[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++)
				d_b[i] = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i <A; i++) {
				st = new StringTokenizer(br.readLine());
				chargers[i] = new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));	
			}
			
			// 연산 
			int ans = 0;
			ans += chargeBattery();
			for(int i = 0; i < M; i++) {
				a_c += d[d_a[i]][0]; a_r += d[d_a[i]][1];
				b_c += d[d_b[i]][0]; b_r += d[d_b[i]][1];
				ans += chargeBattery();
				
			}
			
			// 출력  
			System.out.println("#" + tc + " " +ans);
		}
	}
	
	// 해당 시간에 최대 충전양을 구하는 함수 
	static int chargeBattery() {
		int max = 0;
		for(int i = 0; i < A; i++) {
			for(int j = 0; j < A; j++) {
				int a = 0, b = 0, temp;
				if(chargers[i].inCoverage(a_r, a_c)) {
					a = chargers[i].p;
				}
				if(chargers[j].inCoverage(b_r, b_c)) { 
					b = chargers[j].p;
				}
				if(i == j) temp = Math.max(a, b);
				else temp = a + b;
				max = Math.max(max, temp);
			}
		}
		return max;
		
		// 실수했던 부분 : BC가 하나일 때 발생하는 오류를 잡지 못했다 (b에 해당하는 충전양을 구할 때 i!=j 조건을 달았음)
	}

}

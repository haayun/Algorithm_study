package BOJ;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16926 {
	
	// 하 우 상 좌
	static int[][] d = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int[][] arr, ans;
	static int N, M, R;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("16926.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		int[][] start = new int[N / 2][M / 2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		long s = System.nanoTime();
//		rotate(0, 0, 3, 3);
		for(int loop = 0; loop < R; loop++) {
			
			for (int i = 0; i < Math.min(N, M) / 2; i++) {
//			for (int j = 0; j < M / 2; j++) {
//				System.out.println(i + " " + j + " " + (N - i - 1) + " " + (M - j - 1));
//			}
//			System.out.println(i + " " + i + " " + (N - i - 1) + " " + (M - i - 1));
				rotate(i, i, (N - i - 1), (M - i - 1));
			}
		}
		System.out.println(System.nanoTime() - s);
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) 
//				System.out.print(arr[i][j] + " ");
//			System.out.println();
//		}
	}

	static void rotate(int sr, int sc, int er, int ec) {
		int save = arr[sr][sc], temp;
		int r = sr + 1, c = sc, dir = 0;
		do {
			temp = arr[r][c];
			arr[r][c] = save;
			save = temp;
			
			r += d[dir][0];
			c += d[dir][1];
			if (r < sr || r > er || c < sc || c > ec) {
				r = r - d[dir][0] + d[(dir + 1) % 4][0];
				c = c - d[dir][1] + d[(dir + 1) % 4][1];
				dir = (dir + 1) % 4;
			}
		} while (r != sr + 1 || c != sc);
	}

}
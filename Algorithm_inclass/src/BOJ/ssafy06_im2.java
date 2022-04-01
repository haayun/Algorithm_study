package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
3
5
8 7 9 5 8
4 8 5 3 5
2 4 0 5 9
0 9 7 4 3
0 6 6 7 9
6
3 4 6 1 4 4
2 3 3 2 5 1
9 0 9 8 5 0
9 5 5 2 7 8
4 2 7 1 4 4
7 9 2 6 7 3
7
9 5 2 8 3 4 9
6 6 9 9 0 4 3
4 3 9 5 0 6 1
3 1 3 6 5 9 0
2 1 3 6 2 0 5
1 6 2 1 8 5 1
3 1 4 4 7 3 3

output
#1 2
#2 1
#3 3

* [제약사항] 
1. NxN 배열의 N은 5 이상 50 이하이다. (5 ≤ N ≤ 50) 
2. NxN 배열의 각 원소값은 0 이상 99 이하이다

 */

public class ssafy06_im2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] board = new int[N][N];
			for(int i =0; i< N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j<N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j <N; j++) {
					int start = board[i][j];
					for(int x = i; x < N; x++) {
						for(int y = j; y < N; y++) {
//							if(start == board[x][y])
								
						}
					}
				}
			}
//			Arrays.sort(cnt);
			
			
			
		}
	}

}

package incomplete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_23288_주사위_굴리기_2 {

	static class Dice {
		int[] num = {1, 2, 3, 4, 5, 6};
		
		void roll(int dir) {
			int top = num[0];
			switch(dir) {
			case 0:
				num[1] = num[4];
				num[4] = num[6];
				num[6] = num[3];
				num[3] = num[1];
				break;
			case 1:
				num[1] = num[5];
				num[5] = num[6];
				num[6] = num[2];
				num[2] = num[1];
				break;
			case 2:
				
				break;
			case 3:
				num[1] = num[2];
				num[2] = num[6];
				num[6] = num[5];
				num[5] = num[1];
				break;
			}
		}
	}
	
	// 동 북 서 남
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}

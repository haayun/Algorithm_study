package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144_미세먼지_안녕 {
	static int R, C, T;
	static int airCleaner;
	static int[][] map;
	static int[][] d = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		// 입력 
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1)
					airCleaner = i; // 공기청정기의 아래 행
			}
		}

		while (T-- > 0) {
			// 1. 미세먼지 확산
			spreadDust();

			// 2. 공기청정기 작동
			cleanAir();
		}
		
		// 남은 미세먼지 양 출력 
		int ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++)
				if(map[i][j] > 0) ans += map[i][j] ;
		}
		System.out.println(ans);

	}

	static void spreadDust() {
		// 1초 후 확산되는 미세먼지
		int[][] addDust = new int[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] <= 0) continue;
				int spread_cnt = 0;
				for (int k = 0; k < 4; k++) {
					int nr = i + d[k][0], nc = j + d[k][1];
					// 범위 체크 & 공기청정기에는 확산 X
					if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == -1) continue;

					addDust[nr][nc] += map[i][j] / 5;
					spread_cnt++;
				}
				// 확산된 양 * 확산된 방향 개수만큼 감소
				map[i][j] -= (map[i][j] / 5) * spread_cnt;
			}
		}

		// 확산되는 미세먼지 더하여 반영
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				map[i][j] += addDust[i][j];

	}

	static void clean(int startR, int endR, boolean isClockWise) {
		int prev = map[0][0], temp;
		int dir = 0;
		int r = 1, c = 0;
		
		if(!isClockWise) {
			prev = 0; dir = 1;
			r = startR; c = 1;
		}
		
	}
	
	
	static void cleanAir() {
		// i : 0 ~ airCleaner - 1 반시계 ( 하 우 상 좌 )
		int prev = map[0][0], temp;
		int dir = 0;
		int r = 1, c = 0;
		
		do {
			if (map[r][c] == -1) prev = 0;
			else {
				temp = map[r][c];
				map[r][c] = prev;
				prev = temp;
			}

			r += d[dir][0]; c += d[dir][1];
			if (r < 0 || r >= airCleaner || c < 0 || c >= C) {
				r = r - d[dir][0] + d[(dir + 1) % 4][0];
				c = c - d[dir][1] + d[(dir + 1) % 4][1];
				dir = (dir + 1) % 4;
			}
		} while(r != 1 || c != 0);
	
		
		// i : airCleaner ~ R - 1 시계 ( 우 하 좌 상 )
		prev = 0;
		dir = 1;
		r = airCleaner; c = 1;
		
		do {
			if(map[r][c] == -1) prev = 0;
			else {
				temp = map[r][c];
				map[r][c] = prev;
				prev = temp;
			}
			
			r += d[dir][0]; c += d[dir][1];
			if(r < airCleaner || r >= R || c < 0 || c >= C) {
				r = r - d[dir][0] + d[(dir + 3) % 4][0];
				c = c - d[dir][1] + d[(dir + 3) % 4][1];
				dir = (dir + 3) % 4;
			}
		} while(r != airCleaner || c != 0);
	}
}

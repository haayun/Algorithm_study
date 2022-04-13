import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_17143_낚시왕3 {

	static class Shark {
		int s, d, z;

		public Shark(int s, int d, int z) {
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Shark[][] map = new Shark[R + 1][C + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			map[r][c] = new Shark(s, d, z);
		}

		int man = 0;
		int answer = 0;

		// 1. 낚시꾼 오른쪽으로 한 칸 이동
		while (man++ < C) {
			
			// 2. 가까운 상어 잡기
			for (int i = 1; i <= R; i++) {
				if (map[i][man] != null) {
					answer += map[i][man].z;
					map[i][man] = null;
					break;
				}
			}

			// 3. 상어 이동하기
			Shark[][] copy = new Shark[R+1][C+1];
			for(int i = 1; i <= R; i++) {
				for(int j= 1; j <= C; j++) {
					if(map[i][j] == null) continue;
					Shark before = map[i][j];
					int[] after = moveShark(i, j, before);
					
					int nr = after[0], nc = after[1];
					if(copy[nr][nc] != null && copy[nr][nc].z > after[4]) continue;
					
					copy[nr][nc] = new Shark(after[2], after[3], after[4]);
				}
			}
			
			for(int i = 1; i <= R; i++) {
				for(int j = 1; j <= C; j++)
					map[i][j] = copy[i][j];
			}

		}
		System.out.println(answer);
	}

	static int[] moveShark(int r, int c, Shark shark) {
		int s = shark.s;
		int d = shark.d;
		int z = shark.z;
		
		// 중복되는 왕복구간 줄이기
		if (d < 2) s %= 2 * (R - 1);
		else s %= 2 * (C - 1);
		
		for (int i = 0; i < s; i++) {
			r += dr[d];
			c += dc[d];
			if (r <= 0 || r > R) {
				r -= dr[d];
				d = (d + 1) % 2;
				r += dr[d];
			}
			if (c <= 0 || c > C) {
				c -= dc[d];
				d = 2 + (d + 1) % 2;
				c += dc[d];
			}
		}
		return new int[] {r, c, s, d, z};
	}

}

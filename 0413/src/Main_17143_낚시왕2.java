import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_17143_낚시왕2 {

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

//		Shark[] sharks = new Shark[M];
//		ArrayList<Shark> sharks = new ArrayList<>();
		ArrayList<Shark>[][] map = new ArrayList[R + 1][C + 1];
		
		for(int i = 1; i <= R; i++) {
			for(int j = 1; j <= C; j++)
				map[i][j] = new ArrayList<>();
		}
		

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
//			sharks[i] = new Shark(r, c, s, d, z);
//			sharks.add(new Shark(r, c, s, d, z));
			map[r][c].add(new Shark(s, d, z));
		}

		int man = 0;
		int answer = 0;
		while (man < C) {
			// 1. 낚시꾼 오른쪽으로 한 칸 이동
			man++;

			// 2. 가까운 상어 잡기
			for (int i = 1; i <= R; i++) {
				if (map[i][man].size() == 0)
					continue;
				answer += map[i][man].get(0).z;
				map[i][man].remove(0);
				break;
			}

			// 3. 상어 이동하기
			ArrayList<int[]> after = new ArrayList<>();
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					if (map[i][j].size() == 0) continue;
					Shark before = map[i][j].get(0);
					map[i][j].remove(0);
					after.add(moveShark(i, j, before));
				}
			}
			
			// 변한 위치에 추가하기
			for (int[] is : after) {
				map[is[0]][is[1]].add(new Shark(is[2], is[3], is[4]));
			}

			// 크기가 제일 큰 상어만 남겨두기
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					if (map[i][j].size() <= 1) continue;
					
					Collections.sort(map[i][j], (e1, e2) -> e2.z - e1.z);
					
					for(int k = 1; k < map[i][j].size(); k++)
						map[i][j].remove(k);
					
				}
			}
//			System.out.println(answer);
//			System.out.println();
		}
		System.out.println(answer);
	}

	static int[] moveShark(int r, int c, Shark shark) {
		int s = shark.s;
		int d = shark.d;
		int z = shark.z;
//		System.out.print(z + " : " + r + " " + c + " -> ");
		for(int i = 0; i < s; i++) {
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
//		System.out.println(r + " " + c);
		return new int[] {r, c, s, d, z};
	}

}

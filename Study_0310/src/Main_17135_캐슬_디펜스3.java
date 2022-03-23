import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17135_캐슬_디펜스3 {

	/*
	 * 메모리 55024
	 * 시간 292
	 */
	static int[][] map, save;
	static int[] p;
	static int N, M, D, ans, cnt;
	static int[][] dir = { { 0, -1 }, { -1, 0 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M];
		save = new int[N][M];
		p = new int[M];
		ans = 0;
		int temp = 0;
		while (++temp <= 3) p[M - temp] = 1;
		
		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				save[i][j] = map[i][j];
			}
		}
		
		// 순열 생성 (궁수 위치)
		do {
			int line = N, attack = 0;
			while (line > 0) { // 게임 종료 조건
				target(line);
				attack += shoot(line);
				move(line - 1);
				line--;
			}
			
			ans = Math.max(ans, attack);
			deepCopy();
			
		} while (np());

		System.out.println(ans);
	}

	// 적 표시
	static void target(int line) {
		for (int i = 0; i < M; i++) {
			if (p[i] == 1)
				bfs(line, i);
		}
	}

	// 가까이 있는 적 탐색
	static void bfs(int r, int c) {
		int[][] dist = new int[N + 1][M];
		for (int i = 0; i < N; i++)
			Arrays.fill(dist[i], D);
		dist[r][c] = 0;

		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c));

		while (!q.isEmpty()) {
			int cr = q.peek().x, cc = q.peek().y;
			q.poll();

			if (dist[cr][cc] > D)
				continue;
			if (map[cr][cc] > 0) {
				map[cr][cc] = 2;
				break;
			}

			for (int i = 0; i < 3; i++) {
				int nr = cr + dir[i][0], nc = cc + dir[i][1];
				if ((nr >= 0) && (nr < N) && (nc >= 0) && (nc < M) && (dist[nr][nc] == D)) {
					dist[nr][nc] = dist[cr][cc] + 1;
					q.offer(new Point(nr, nc));
				}
			}
		}
	}

	// 적의 수 카운트
	static int shoot(int line) {
		int cnt = 0;
		for (int i = 0; i < line; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) {
					map[i][j] = 0;
					cnt++;
				}
			}
		}
		return cnt;

	}

	// 적 이동 -> 궁수 이동
	static void move(int line) {
		for (int i = 0; i < M; i++) {
			if (map[line][i] > 0)
				map[line][i] = 0;
		}

	}

	// 2차원 배열 깊은 복사
	static void deepCopy() {
		for (int i = 0; i < N; i++) {
			System.arraycopy(save[i], 0, map[i], 0, M);
		}
	}

	// next permutation
	static boolean np() {
		int i = M - 1;
		while (i > 0 && p[i - 1] >= p[i])
			--i;

		if (i == 0)
			return false;

		int j = M - 1;
		while (p[i - 1] >= p[j])
			--j;

		swap(i - 1, j);

		int k = M - 1;
		while (i < k) {
			swap(i++, k--);
		}

		return true;
	}

	static void swap(int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}

}

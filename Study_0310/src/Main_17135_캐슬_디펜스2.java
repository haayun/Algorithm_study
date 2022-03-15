import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17135_캐슬_디펜스2 {

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
		map = new int[N +1][M];
		save = new int[N +1][M];
		p = new int[M];
		ans = 0;
		int temp = 0;
		while (++temp <= 3) p[M - temp] = 1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				save[i][j] = map[i][j];
			}
		}
		
		
		System.out.println(ans);
	}

	static void bfs(int r, int c) {
		int[][] dist = new int[N + 1][M];
		for(int i = 0; i < N; i++)
			Arrays.fill(dist[i], D);
		dist[r][c] = 0;
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c));
		
		while(!q.isEmpty()) {
			int cr = q.peek().x, cc = q.peek().y;
			q.poll();
			
			if(dist[cr][cc] > D) continue;
			if(map[cr][cc] == 1) {
				map[cr][cc] = 2;
				break;
			}
			
			for(int i = 0; i < 3; i++) {
				int nr = cr + dir[i][0], nc = cc + dir[i][1];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || dist[nr][nc] != D) continue;
				dist[nr][nc] = dist[cr][cc] + 1;
				q.offer(new Point(nr, nc));
			}
		}
	}
	
	static void attack() {
		
	}
	
	// 공격하기
	static int shoot(int line) {
		int cnt = 0;
		for(int i = 0; i < line; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 2) {
					map[i][j] = 0;
					cnt++;
				}
			}
		}
		return cnt;

	}

	// 적 이동
	static void move(int line) {
		for(int i = 0; i < M; i++) {
			if(map[line][i] > 0) map[line][i] = 0;
		}

	}

	// 게임 종료 조건
	static boolean gameOver() {

		int sum = 0;
		for (int[] is : map) {
			for (int i : is) {
				sum += i;
			}
		}

		return sum == 0 ? true : false;
	}

	// 2차원 배열 깊은 복사
	static void deepCopy() {
		for (int i = 0; i < N; i++) {
			System.arraycopy(save[i], 0, map[i], 0, M);
		}
	}

	static void combination(int cnt, int start) {
		if (cnt ==3) {
			deepCopy();
			attack();
			return;
		}
		for (int i = start; i<M; i++) {
			p[cnt]= i; 
			combination(cnt+1, i+1);
		}
	}

}

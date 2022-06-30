

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_23288_주사위_굴리기_2 {

	// 동 북 서 남
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };

	static int[] dice = { 1, 2, 3, 4, 5, 6 };
	static int r = 0, c = 0;
	
	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int score = 0;
		int dir = 0; // 처음 방향 : 동
		while (K-- > 0) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
				
				dir = (dir + 2) % 4; // 반대
				nr = r + dr[dir];
				nc = c + dc[dir];
			}
			// 1. 주사위가 이동 방향으로 한 칸 굴러간다.
			roll(dir);
			r = nr;
			c = nc;
			
			// 2. 주사위가 도착한 칸 (x, y)에 대한 점수를 획득한다. 
			score += map[r][c] * bfs(r, c);
			
			// 3. 이동 방향을 결정한다.
			int A = dice[5], B = map[r][c];
			if(A > B) {
				dir = (dir + 3) % 4;
			} else if (A < B) {
				dir = (dir + 1) % 4;
			}
			
		}
		
		System.out.println(score);
	}

	static int bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
	
		queue.add(new Point(r, c));
		visited[r][c] = true;
		
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int cr = queue.peek().x;
			int cc = queue.peek().y;
			queue.poll();
			cnt++;
			
			for(int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if(visited[nr][nc] || map[r][c] != map[nr][nc]) continue;
				
				queue.add(new Point(nr, nc));
				visited[nr][nc] = true;
			}
		}
		return cnt;
	}

	static void roll(int dir) {
		int top = dice[0];
		switch (dir) {
		case 0: // 동
			dice[0] = dice[3];
			dice[3] = dice[5];
			dice[5] = dice[2];
			dice[2] = top;
			break;
		case 1: // 북
			dice[0] = dice[4];
			dice[4] = dice[5];
			dice[5] = dice[1];
			dice[1] = top;
			break;
		case 2: // 서
			dice[0] = dice[2];
			dice[2] = dice[5];
			dice[5] = dice[3];
			dice[3] = top;
			break;
		case 3: // 남
			dice[0] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[4];
			dice[4] = top;
			break;
		}
	}

}

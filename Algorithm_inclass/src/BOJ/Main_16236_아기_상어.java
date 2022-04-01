package BOJ;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_아기_상어 {

	static class Shark {
		Point p; // 현재 위치
		int size; // 현재 크기
		int eat; // 현재 먹은 물고기 수

		Shark(int x, int y) {
			p = new Point(x, y);
			size = 2;
			eat = 0;
		}
	}

	static class Fish implements Comparable<Fish> {
		Point p;
		int dist;

		Fish(int x, int y, int dist) {
			this.p = new Point(x, y);
			this.dist = dist;
		}

		@Override
		public int compareTo(Fish o) {
			// TODO Auto-generated method stub
			if (this.dist != o.dist) return this.dist - o.dist;
			if (this.p.x != o.p.x) return this.p.x - o.p.x;
			return this.p.y - o.p.y;
		}
	}

	static Shark baby;
	static int N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 입력 
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9)
					baby = new Shark(i, j);
			}
		}
		// 연산 
		int ans = 0;
		while (true) {
			// 현재 먹을 물고기 탐색 
			Fish curFish = bfs();
			if (curFish == null) break;
			// 먹기 (크기 또는 먹은 개수 갱신)  
			baby.eat++;
			if (baby.eat == baby.size) {
				baby.size++;
				baby.eat = 0;
			}
			
			// 기존 위치, 먹은 위치는 0으로 변환, 이동 
			ans += curFish.dist;
			map[curFish.p.x][curFish.p.y] = 0;
			map[baby.p.x][baby.p.y] = 0;
			baby.p = curFish.p;
		}
		// 출력 
		System.out.println(ans);

	}

	// bfs 탐색 
	static Fish bfs() {
		int[][] d = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int[][] visited = new int[N][N];
		// 후보들 중 최적 위치를 찾기 위해 우선순위 큐 사용 
		PriorityQueue<Fish> pq = new PriorityQueue<>();
		Queue<Point> queue = new LinkedList<>();
		
		visited[baby.p.x][baby.p.y] = 1;
		queue.offer(baby.p);

		while (!queue.isEmpty()) {
			int r = queue.peek().x;
			int c = queue.peek().y;
			int dist = visited[r][c];
			queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = r + d[i][0], nc = c + d[i][1];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] != 0 || map[nr][nc] > baby.size) continue;
				visited[nr][nc] = visited[r][c] + 1;
				if(map[nr][nc] != 0 && map[nr][nc] < baby.size) {
					pq.add(new Fish(nr, nc, visited[nr][nc] - 1));
					continue;
				}
				queue.offer(new Point(nr, nc));
			}
		}	
	
		if(pq.isEmpty()) return null;
		return pq.poll();
	}

}

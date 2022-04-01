package BOJ;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {
	static int N, M, cnt;
	static int[][] d = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int[][] box;
	static Queue<Point> queue;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		box = new int[N][M];
		cnt = N * M;		// 총 익는 토마토 개수 
		queue = new LinkedList<>();

		// 입력 & 익은 토마토는 큐에 삽입 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 1) 
					queue.offer(new Point(i, j));
				else if (box[i][j] == -1) 
					cnt--;	// 토마토가 들어있지 않다면 cnt 감소 
				
			}
		}
		
		System.out.println(bfs());
		
	}

	static int bfs() {
		int t = 0;	// 걸리는 일수 
		while (!queue.isEmpty()) {
			int cr = queue.peek().x, cc = queue.peek().y;
			queue.poll();
			t = box[cr][cc];
			cnt--;	// 큐에 들어갔으면 익었다는 뜻
			
			for (int i = 0; i < 4; i++) {
				int nr = cr + d[i][0], nc = cc + d[i][1];
				// 경계 체크 & 익지 않은 토마토가 아니라면 pass 
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || box[nr][nc] != 0) continue;
				
				//하루 지나면 익음 
				box[nr][nc] = box[cr][cc] + 1;
				queue.offer(new Point(nr, nc));
			}
		}
		// 최소 일수 반환 (익지 않은 토마토가 남았으면 -1 반환) 
		return cnt == 0 ? t - 1 : -1;
	}
	

}

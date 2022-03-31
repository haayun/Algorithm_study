import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이_되고픈_원숭이 {
	static int[][] d = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, 		// 인접 칸 이동
			{ -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 }, { 2, -1 }, { 2, 1 } };	// 말 이동

	static class Point {
		int horse, r, c;

		public Point(int horse, int r, int c) {
			this.horse = horse;
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][] board = new int[H][W];
		
		// 입력
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
		// bfs 연산
		int[][][] visited = new int[K + 1][H][W];	// 현재 말 이동 횟수, 위치
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0, 0));
		visited[0][0][0] = 1;
		
		int ans = -1;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			
			
			// 마지막칸에 도착하면 종료
			if (cur.r == H - 1 && cur.c == W - 1) {
				ans = visited[cur.horse][cur.r][cur.c] - 1;
				break;
			}

			for(int i = 0; i < 4; i++) {	// 인접 이동
				int nr = cur.r + d[i][0], nc = cur.c + d[i][1];
				// 경계체크, 방문체크
				if (nr < 0 || nr >= H || nc < 0 || nc >= W || board[nr][nc] == 1 || visited[cur.horse][nr][nc] != 0) continue;
				
				queue.offer(new Point(cur.horse, nr, nc));
				visited[cur.horse][nr][nc] = visited[cur.horse][cur.r][cur.c] + 1;				
			}
			if(cur.horse >= K) continue;	// 이미 K번만큼 움직였다면 더이상 말의 이동 불가
			
			for (int i = 4; i < d.length; i++) {	// 말 이동
				int nh = cur.horse + 1, nr = cur.r + d[i][0], nc = cur.c + d[i][1];
				// 경계체크, 방문체크
				if (nr < 0 || nr >= H || nc < 0 || nc >= W || board[nr][nc] == 1 || visited[nh][nr][nc] != 0) continue;
				
				queue.offer(new Point(nh, nr, nc));
				visited[nh][nr][nc] = visited[cur.horse][cur.r][cur.c] + 1;

			}
		}
		
		// 출력
		System.out.println(ans);
		return;
	}

}

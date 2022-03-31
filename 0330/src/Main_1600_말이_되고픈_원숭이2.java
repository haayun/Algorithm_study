import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이_되고픈_원숭이2 {
	static int[] hr = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] hc = { -1, 1, -2, 2, -2, 2, -1, 1 };
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

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
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][][] visited = new int[K + 1][H][W];

		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0, 0));
		visited[0][0][0] = 1;
		
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			
			if(cur.r == H-1 && cur.c == W-1) {
				System.out.println(visited[cur.horse][cur.r][cur.c] - 1);
				return;
			}
			
			for (int i = 0; i < dr.length; i++) {
				int nr = cur.r + dr[i], nc = cur.c + dc[i];
				if (nr < 0 || nr >= H || nc < 0 || nc >= W || board[nr][nc] == 1) continue;
				if(visited[cur.horse][nr][nc] != 0) continue;
				
				queue.offer(new Point(cur.horse, nr, nc));
				visited[cur.horse][nr][nc] = visited[cur.horse][cur.r][cur.c] + 1;
			}

			for (int i = 0; i < hr.length; i++) {
				int nr = cur.r + hr[i], nc = cur.c + hc[i];
				if (nr < 0 || nr >= H || nc < 0 || nc >= W || board[nr][nc] == 1) continue;
				if (cur.horse >= K) continue;
				if(visited[cur.horse+1][nr][nc] != 0) continue;

				queue.offer(new Point(cur.horse+1, nr, nc));
				visited[cur.horse + 1][nr][nc] = visited[cur.horse][cur.r][cur.c] + 1;
			}

		}
		
		System.out.println("-1");
		return;

	}

}

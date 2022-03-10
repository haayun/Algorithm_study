import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16918_봄버맨2 {

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int R, C;
	static int[][] board;
	static Queue<Point> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		if (N % 2 == 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					sb.append('O');
				}
				sb.append('\n');
			}
			System.out.println(sb);
			return;
		}

		
		board = new int[R][C];
		for (int i = 0; i < R; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j = 0; j < C; j++) {
				if(temp[j] == 'O') {
					board[i][j] = 2;
				}
			}
		}

		int time = 1;

		while (--N > 0) {

			if (++time % 2 == 0)
				putBomb();
			else {
				while(!queue.isEmpty()) {
					explode(queue.poll());
				}
			}

		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(board[i][j] == 0 ? '.' : 'O');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	static void putBomb() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 0) 
					board[i][j] = 2;
				else
					board[i][j] ++;
				
				if(board[i][j] == 3)
					queue.offer(new Point(i, j));
			}
		}
	}

	static void explode(Point cur) {
		int cr = cur.x, cc = cur.y;
		board[cr][cc] = 0;
		for (int d = 0; d < 4; d++) {
			int nr = cr + dr[d], nc = cc + dc[d];
			if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
			board[nr][nc] = 0;
		}
	}

}

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {
	static int N, M, ans, cnt;
	static int[][] tomato;
	static int[][] d = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Queue<Point> queue;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		tomato = new int[N][M];
		queue = new LinkedList<>();

		cnt = N * M;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == 1)
					queue.offer(new Point(i, j));

				else if(tomato[i][j] == -1)
					cnt--;
			}
		}

		bfs();

		System.out.println(ans);
	}

	static void bfs() {
		int t = 0;
		while (!queue.isEmpty()) {
			int r = queue.peek().x;
			int c = queue.peek().y;
			queue.poll();
			t = tomato[r][c];
			cnt--;
			for (int i = 0; i < 4; i++) {
				int nr = r + d[i][0];
				int nc = c + d[i][1];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && tomato[nr][nc] == 0) {
					tomato[nr][nc] = tomato[r][c] + 1;
					queue.offer(new Point(nr, nc));
				}
			}
		}
		
		// 안 익은 토마토 개수 체크 
		if (cnt == 0)
			ans = t - 1;
		else
			ans = -1;
	}

}

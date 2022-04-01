package BOJ;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026_적록색약 {
	static int N;
	static char[][] colors_1, colors_2;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		colors_1 = new char[N][];
		colors_2 = new char[N][N];

		for (int i = 0; i < N; i++) {
			colors_1[i] = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (colors_1[i][j] == 'G')
					colors_2[i][j] = 'R';
				else
					colors_2[i][j] = colors_1[i][j];
			}
		}
		int ans_1 = 0, ans_2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (colors_1[i][j] != '0') {
					ans_1++;
					bfs(colors_1, new Point(i, j));
				}
				if (colors_2[i][j] != '0') {
					ans_2++;
					bfs(colors_2, new Point(i, j));
				}
			}
		}
		System.out.println(ans_1 + " " + ans_2);
	}

	static int[][] d = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	static void bfs(char[][] colors, Point p) {
		Queue<Point> queue = new LinkedList<>();
		char c = colors[p.x][p.y];
		queue.offer(p);
		colors[p.x][p.y] = '0';

		while (!queue.isEmpty()) {
			int cr = queue.peek().x, cc = queue.peek().y;
			queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cr + d[i][0], nc = cc + d[i][1];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || colors[nr][nc] != c) continue;

				queue.offer(new Point(nr, nc));
				colors[nr][nc] = '0';
			}
		}
	}

}

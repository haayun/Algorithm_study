import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2667_단지번호붙이기 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		ans = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp[j] - '0';
			}
		}

		int[][] d = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		Queue<Point> queue = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) continue;

				queue.offer(new Point(i, j));
				map[i][j] = 0;
				int cnt = 0;
				while (!queue.isEmpty()) {
					int r = queue.peek().x, c = queue.peek().y;
					cnt++;
					queue.poll();
					
					for (int k = 0; k < 4; k++) {
						int nr = r + d[k][0], nc = c + d[k][1];
						if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 0)	continue;
						map[nr][nc] = 0;
						queue.add(new Point(nr, nc));
					}
				}
				ans.add(cnt);
			}
		}
		System.out.println(ans.size());
		Collections.sort(ans);
		for(int apart : ans)
			System.out.println(apart);
	}	
}

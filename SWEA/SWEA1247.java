package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1247 {
	
	static class place {
		int x, y;

		place(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "[" + x + ", " + y + "]";
		}
	}

	static int N, ans;
	static boolean[] visited;
	static place[] places;
	static place company, home;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			ans = Integer.MAX_VALUE;
			visited = new boolean[N];
			places = new place[N];

			st = new StringTokenizer(br.readLine(), " ");
			company = new place(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new place(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			for (int i = 0; i < N; i++) {
				places[i] = new place(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			getDist(0, 0, company);

			System.out.println("#" + tc + " " + ans);
		}
	}

	static void getDist(int cnt, int sum, place prev) {
		if (sum >= ans)
			return;

		if (cnt == N) {
			ans = Math.min(ans, sum + Math.abs(prev.x - home.x) + Math.abs(prev.y - home.y));
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			getDist(cnt + 1, sum + Math.abs(prev.x - places[i].x) + Math.abs(prev.y - places[i].y), places[i]);
			visited[i] = false;
		}
	}
}

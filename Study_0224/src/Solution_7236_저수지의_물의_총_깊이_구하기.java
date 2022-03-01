import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7236_저수지의_물의_총_깊이_구하기 {
	static int N;
	static char[][] map;
	static int[][] d = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			int ans = 1;
			outer: for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'G')
						continue;
					ans = Math.max(ans, getDepth(i, j));
					if (ans == 7)
						break outer;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);
	}

	static int getDepth(int r, int c) {
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			int nr = r + d[i][0], nc = c + d[i][1];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;
			if (map[nr][nc] == 'W')
				cnt++;
		}
		return cnt;
	}

}

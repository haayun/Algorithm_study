import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_11315_오목판정 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[][] board = new char[N][];
			for (int i = 0; i < N; i++) {
				board[i] = br.readLine().toCharArray();
			}
			boolean flag = isOmok(board, N);
			System.out.println("#" + tc + " " + (flag ? "YES" : "NO"));
		}

	}

	static boolean isOmok(char[][] board, int N) {
		int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == '.') continue;
				for (int d = 0; d < 8; d++) {
					int cnt = 0;
					int nr = i, nc = j;
					while (nr >= 0 && nr < N && nc >= 0 && nc < N && board[nr][nc] == 'o') {
						cnt++;
						nr += dr[d];
						nc += dc[d];
					}
					if (cnt >= 5) {
						return true;
					}
				}
			}
		}
		return false;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16918_봄버맨 {

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int R, C;
	static char[][] board;

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

		board = new char[R][];
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}

		int time = 1;

		while (--N > 0) {

			if (++time % 2 == 0)
				putBomb(time);
			else
				explode(time);

		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 'X')
					board[i][j] = 'O';
				sb.append(board[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	static void putBomb(int time) {
		char bomb = (time + 1) / 2 % 2 == 0 ? 'O' : 'X';
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == '.') {
					board[i][j] = bomb;
				}
			}
		}
	}

	static void explode(int time) {
		char[][] temp = new char[R][C];
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				temp[i][j] = board[i][j];

		char bomb = (time + 1) / 2 % 2 == 0 ? 'O' : 'X';
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] != bomb)
					continue;
				temp[i][j] = '.';
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d], nc = j + dc[d];
					if (nr < 0 || nr >= R || nc < 0 || nc >= C)
						continue;
					temp[nr][nc] = '.';
				}
			}
		}
		board = temp.clone();
	}

}

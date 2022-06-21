import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499_주사위_굴리기 {

	static class Dice {
		int[] idx = new int[6];

		void roll(int dir) {
			int top = idx[0];
			switch (dir) {
			case 1:
				idx[0] = idx[3];
				idx[3] = idx[5];
				idx[5] = idx[2];
				idx[2] = top;
				break;
			case 2:
				idx[0] = idx[2];
				idx[2] = idx[5];
				idx[5] = idx[3];
				idx[3] = top;
				break;
			case 3:
				idx[0] = idx[4];
				idx[4] = idx[5];
				idx[5] = idx[1];
				idx[1] = top;
				break;
			case 4:
				idx[0] = idx[1];
				idx[1] = idx[5];
				idx[5] = idx[4];
				idx[4] = top;
				break;
			}
		}
	}

	static int[] dr = { 0, 0, 0, -1, 1 };
	static int[] dc = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		Dice dice = new Dice();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		while (K-- > 0) {
			int dir = Integer.parseInt(st.nextToken());
			int nr = r + dr[dir], nc = c + dc[dir];
			if (nr < 0 || nr >= N || nc < 0 || nc >= M)
				continue;
			r = nr;
			c = nc;

			dice.roll(dir);

			if (map[r][c] == 0) {
				map[r][c] = dice.idx[5];
			} else {
				dice.idx[5] = map[r][c];
				map[r][c] = 0;
			}
			System.out.println(dice.idx[0]);
		}
	}

}

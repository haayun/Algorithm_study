import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2448_별_찍기_11 {
/*
 * 메모리 235224
 * 시간 484
 */
	static char[][] star;
	static int N;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		star = new char[N][N * 2 - 1];

		printStar(0, 0, N);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2 * N - 1; j++) {
				sb.append(star[i][j] == '*' ? '*' : ' ');
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	static void triangle(int r, int c) {
		star[r][c + 2] = '*';
		star[r + 1][c + 1] = star[r + 1][c + 3] = '*';
		for (int i = 0; i < 5; i++) star[r + 2][c + i] = '*';
	}

	static void printStar(int row, int col, int n) {

		if (n == 3) {
			triangle(row, col);
			return;
		}

		printStar(row, col + n / 2, n / 2);
		printStar(row + n / 2, col, n / 2);
		printStar(row + n / 2, col + n, n / 2);
	}

}

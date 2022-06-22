import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992_쿼드트리 {

	static int N;
	static int[][] img;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		img = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				img[i][j] = Integer.parseInt(s.substring(j, j + 1));
			}
		}
		System.out.println(divideConquer(0, 0, N));
	}

	static String divideConquer(int sr, int sc, int n) {
		if (n == 1 || checkIfOne(sr, sc, n))
			return Integer.toString(img[sr][sc]);

		int half = n / 2;
		return "(" + divideConquer(sr, sc, half) + divideConquer(sr, sc + half, half)
				+ divideConquer(sr + half, sc, half) + divideConquer(sr + half, sc + half, half) + ")";

	}

	static boolean checkIfOne(int sr, int sc, int n) {
		int start = img[sr][sc];
		for (int i = sr; i < sr + n; i++) {
			for (int j = sc; j < sc + n; j++) {
				if (start != img[i][j])
					return false;
			}
		}
		return true;
	}
}

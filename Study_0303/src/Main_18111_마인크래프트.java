import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18111_마인크래프트 {

	static int N, M, B;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		int max = 0;

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}

		if (max > 256)
			max = 256;

		int time = Integer.MAX_VALUE, height = 0;
		for (int i = max; i >= 0; i--) {
			int res = evenGround(i);
			if (res == -1)
				continue;
			if (time > res) {
				time = res;
				height = i;
			}
		}

		System.out.println(time + " " + height);

	}

	static int evenGround(int height) {
		int plus = 0, minus = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > height)
					minus += map[i][j] - height;
				else if (map[i][j] < height)
					plus += height - map[i][j];
			}
		}
		if (minus + B < plus)
			return -1;
		return minus * 2 + plus;

	}

}

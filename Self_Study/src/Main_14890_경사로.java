

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14890_경사로 {

	static int[][] map;
	static int N, L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 연산
		int road = 0;
		for (int i = 0; i < N; i++) {
			// 가로 길
			if (isRoad(map[i]))
				road++;
//			// 세로 길
			int[] colRoad = new int[N];
			for (int j = 0; j < N; j++) {
				colRoad[j] = map[j][i];
			}
			if (isRoad(colRoad))
				road++;
		}

		// 출력
		System.out.println(road);
	}

	static boolean isRoad(int[] road) {
		int prevHeight = road[0];
		boolean flag = false;
		int up = 1;
		int down = 0;
		for (int i = 1; i < N; i++) {
			if (prevHeight - road[i] == 1) {
				if (down > 0)
					return false;
				down = L - 1;
				up = 0;
			} else if (prevHeight - road[i] == -1) {
				if (up < L)
					return false;
				up = 1;

			} else if (prevHeight == road[i]) {
				if (down > 0)
					down--;
				else
					up++;
			} else {
				return false;
			}
			prevHeight = road[i];
		}
		if (down > 0)
			return false;
//		System.out.println(Arrays.toString(road));
		return true;
	}
}

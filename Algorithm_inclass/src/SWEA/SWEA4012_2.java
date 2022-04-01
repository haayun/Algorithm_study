package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4012_2 {

	static int N, R, ans;
	static boolean[] visited;
	static int[][] synergy;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			R = N / 2;
			synergy = new int[N][N];
			visited = new boolean[N];

			// 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 연산
			ans = Integer.MAX_VALUE;
			combination(0, 0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
        // 출력
		System.out.println(sb);

	}

	static void combination(int cnt, int start) {
		if (cnt == R) {
			int half_1 = 0, half_2 = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (visited[i] && visited[j]) half_1 += synergy[i][j] + synergy[j][i];
					else if (!visited[i] && !visited[j])  half_2 += synergy[i][j] + synergy[j][i];
				}
			}
			ans = Math.min(ans, Math.abs(half_1 - half_2));
		}

		for (int i = start; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				combination(cnt + 1, i + 1);
				visited[i] = false;
			}
		}
	}
}

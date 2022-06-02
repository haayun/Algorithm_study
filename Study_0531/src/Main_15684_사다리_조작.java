import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15684_사다리_조작 {
	static int N, M, H, answer = 4;
	static int[][] cross;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		cross = new int[H + 1][N + 1];
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= N; j++) {
				cross[i][j] = j;
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			cross[a][b] = b + 1;
			cross[a][b + 1] = b;
		}
		// 연산
		dfs(1, 0);
		
		// 출력
		System.out.println(answer == 4? "-1" : answer);
	}

	static void dfs(int idx, int cnt) {
		// 백트래킹 조건
		if(cnt > 3 || cnt > answer) return;
		// 정답인지 확인
		if(isAnswer()) {
			answer = Math.min(answer, cnt);
			return;
		}

		for (int i = idx; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if (cross[i][j] != j) continue;
				if(cross[i][j+1] != j+1) continue;
				
				cross[i][j] = j + 1;
				cross[i][j + 1] = j;

				dfs(i, cnt + 1);

				cross[i][j] = j;
				cross[i][j + 1] = j + 1;

			}
		}
	}
	// 각 번호대로 도착하는지 확인
	static boolean isAnswer() {
		for (int i = 1; i <= N; i++) {
			int trace = cross[1][i];
			for (int j = 2; j <= H; j++) {
				trace = cross[j][trace];
			}
			if (i != trace)
				return false;
		}
		
		return true;
	}
}

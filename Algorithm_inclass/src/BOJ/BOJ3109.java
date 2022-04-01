package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3109 {

	static int R, C;
	// 우상, 우, 우하
	static int[][] d = { { -1, 1 }, { 0, 1 }, { 1, 1 } };
	static int ans;
	static char[][] map;
	static boolean[][] visited;
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++)
			map[i] = br.readLine().toCharArray();
		
		
		for(int i = 0; i <R; i++) {
			dfs(i, 0);
		}
		System.out.println(ans);
	}

	static void dfs(int row, int col) {

		if (map[row][col] == 'x') {
			// 가다가 건물을 만나면 퇴각
			return;
		}

		if (col == C-1) {
			// 깊이 C까지 닿았다면 파이프라인 연결 성공 (경로를 저장한 채로)
			ans++;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (visited[i][j])
						map[i][j] = 'x';
				}
			}
			flag = true;
			return;
		}

		for (int i = 0; i < 3; i++) {
			int nr = row + d[i][0], nc = col + d[i][1];
			if (nr < 0 || nr >= R || nc < 0 || nc >= C)
				continue;
			System.out.println(nr +" " + nc);
			visited[nr][nc] = true;
			dfs(nr, nc);
			if(flag == true)
				break;
			visited[nr][nc] = false;
		}

	}
}

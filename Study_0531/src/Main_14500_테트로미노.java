import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {

	static int N, M, max = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 연산
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, map[i][j]);
				visited[i][j] = false;
				
				pinkBlock(i, j);
			}
		}
		
		System.out.println(max);
	}
	
	static void pinkBlock(int r, int c) {
		// ㅓ ㅏ
		if(r + 2 < N) {
			int temp = map[r][c] + map[r+1][c] + map[r+2][c];
			if(c - 1 >= 0) max = Math.max(max, temp + map[r+1][c-1]);	// ㅓ
			if(c + 1 < M) max = Math.max(max, temp + map[r+1][c+1]);	// ㅏ
		}
		// ㅗ ㅜ 
		if(c + 2 < M) {
			int temp = map[r][c] + map[r][c + 1] + map[r][c + 2];
			if(r - 1 >= 0) max = Math.max(max, temp + map[r-1][c+1]);	// ㅗ
			if(r +1 < N) max = Math.max(max, temp + map[r+1][c+1]);		// ㅜ
		}
	}
	
	// ㅡ ㄱ ㄹ ㅁ
	static void dfs(int r, int c, int cnt, int sum) {
		if(cnt == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i], nc = c + dc[i];
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			if(visited[nr][nc]) continue;
			visited[nr][nc] = true;
			dfs(nr, nc, cnt+1, sum + map[nr][nc]);
			visited[nr][nc] = false;
		}
		
	}
}

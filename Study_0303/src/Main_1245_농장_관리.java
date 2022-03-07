import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1245_농장_관리 {

	static int[][] farm;
	static boolean[][] visited;
	static boolean flag = true;
	static int N, M, cnt;
	
	static int[] dr = {1, 1, 1, -1, -1, -1, 0, 0};
	static int[] dc = {1, 0, -1, 1, 0, -1, 1, -1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		farm = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				farm[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(farm[i][j] == 0 || visited[i][j]) continue;
				visited[i][j] = true;
				flag = true;
				dfs(i, j);
				if(flag) cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	static void dfs(int r, int c) {
		
		for(int i = 0; i < 8; i++) {
			int nr = r + dr[i], nc = c + dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			if(farm[r][c] < farm[nr][nc]) flag = false;
			if(!visited[nr][nc] && farm[r][c] == farm[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc);				
			}
		}
		
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012_유기농_배추 {
	
	static int[][] field;
	static int N, M;
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken()) + 1;
			N = Integer.parseInt(st.nextToken()) + 1;
			int K = Integer.parseInt(st.nextToken());
			
			field = new int[M][N];
			
			// 입력 
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				field[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			
			// 연산 : 영역 개수 세기 
			int cnt = 0;
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					if(field[i][j] == 1) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			
			// 출력 
			System.out.println(cnt);
		}
		
	}
	
	// 인접한 배추 땅을 탐색 
	static void dfs(int c, int r) {
		
		field[c][r] = 0;	// 방문 체 
		int nr, nc;
		
		for(int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || field[nc][nr] == 0) continue;
			
			dfs(nc, nr);
		}
	}

}

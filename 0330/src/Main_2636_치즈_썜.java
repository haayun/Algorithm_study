import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2636_치즈_썜 {

	static int[][] map;
	static int R, C, cnt;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C= Integer.parseInt(st.nextToken());

		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}

		int time = 0;
		int ans = 0;
		
		while(true) {
			cnt= 0;
			dfs(0, 0);
			if(cnt == 0) break;
			time++;
//			before = cnt;
			processAir();
		}

		System.out.println(time + "\n" + ans);
	}
	
	static void processAir() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == 2 || map[i][j] == -1)
					map[i][j] = 0;
			}
		}
	}
	

	static void dfs(int r, int c) {
		int nr, nc;
		for(int d = 0; d<4; ++d) {
			nr = r + dr[d];
			nc = c+dc[d];
			if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
				if(map[nr][nc]==1) {
					map[nr][nc] = 2;
					cnt++;
				}
			}
		}
	}
}

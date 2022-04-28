import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 시뮬레이션
public class Main_16234_인구이동2 {

	static int N, L, R;
	static int[][] map, union;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 0;
		while(true) {
			ArrayList<Point> countries = new ArrayList<>(); 
			union = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(union[i][j] == 0) {
						countries.add(dfs(i, j, 1));
					}
				}
			}
			
			for(int i = 0; i < countries.size(); i++) {
				
			}
			
			time++;
			if(countries.size() == 0) break;
		}
			
//		for(int i = 0; i < N; i++)
//			System.out.println(Arrays.toString(union[i]));
		System.out.println(time);
	}
	static Point dfs(int r, int c, int cnt) {
		Point cur = new Point(map[r][c], 1);
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i], nc = c + dc[i];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if(union[nr][nc] > 0) continue;
			int diff = Math.abs(map[r][c] - map[nr][nc]);
			if(diff < L || diff > R) continue;
			union[nr][nc] = cnt;
			Point next = dfs(nr, nc, cnt);
			cur.x += next.x;
			cur.y += next.y;
		}
		return cur;
	}
	
}

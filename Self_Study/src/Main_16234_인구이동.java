import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시뮬레이션
public class Main_16234_인구이동 {

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
		// 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 0;	// 며칠동안 발생하는지 구하기
		while(true) {
			// 연합 또는 독립적인 나라를 저장하는 리스트
			ArrayList<Point> countries = new ArrayList<>(); 
			union = new int[N][N];
			int cnt = 1;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(union[i][j] == 0) {
						union[i][j] = cnt;
						countries.add(dfs(i, j, cnt++));
					}
				}
			}
			// 모든 국경선이 닫혀있다면 = 인구이동이 없음
			if(countries.size() == N * N) break;
			
			for(int c = 0; c < countries.size(); c++) {
				Point cur = countries.get(c);
				if(cur.y == 1) continue;
				int afterPop = cur.x / cur.y;
				// 연합 인구수 변경				
				for(int i =0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if(union[i][j] == c+1)
							map[i][j] = afterPop;
					}
				}
			}
			
			time++;
		}
		// 출력
		System.out.println(time);
	}
	// 국경선 열기
	static Point dfs(int r, int c, int cnt) {
		Point cur = new Point(map[r][c], 1);	// x : 연합의 인구수 y : 연합을 이루고 있는 칸의 개수 
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i], nc = c + dc[i];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;	// 경계 체크
			if(union[nr][nc] > 0) continue;		// 이미 연합한 나라인지 체크
			int diff = Math.abs(map[r][c] - map[nr][nc]);
			if(diff < L || diff > R) continue;	// 인구 차이 체크
			union[nr][nc] = cnt;
			Point next = dfs(nr, nc, cnt);
			cur.x += next.x;
			cur.y += next.y;
		}
		return cur;
	}
	
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_달이_차오른다_가자 {
	
	static class Point{
		int r, c, key;

		public Point(int r, int c, int key) {
			this.r = r;
			this.c = c;
			this.key = key;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		
		int[] dr = {0, 0, 1, -1};
		int[] dc = {1, -1, 0, 0};
		
		int sr = 0, sc = 0;
		
		// 입력 
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				if(map[i][j] == '0') {
					sr = i;
					sc = j;
				}
			}
		}
		
		Queue<Point> queue = new LinkedList<>();
		int[][][] visited = new int[N][M][1<<6];	// 방문 체크 & 횟수 카운팅 배열
		queue.offer(new Point(sr, sc, 0));
		visited[sr][sc][0] = 1;			
		
		Point end = null;
		
		// bfs 연산
		while(!queue.isEmpty()) {
			int cr = queue.peek().r, cc = queue.peek().c;
			int c_key = queue.peek().key;
			
			queue.poll();
			
			if(map[cr][cc] == '1') {
				end = new Point(cr, cc, c_key);
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = cr + dr[i], nc = cc + dc[i];
				
				// 경계 체크, 벽 체크
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc][c_key] != 0 || map[nr][nc] == '#') continue;
				
				// 문 체크 (통과할 수 있는지 확인)
				if(map[nr][nc] >= 'A' && map[nr][nc] <= 'F' && (c_key & 1<<(map[nr][nc] - 'A')) == 0) continue;
				
				int n_key = c_key;
				if(map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
					n_key |= 1<<(map[nr][nc] - 'a');
				}
				
				queue.offer(new Point(nr, nc, n_key));
				visited[nr][nc][n_key] = visited[cr][cc][c_key] + 1;
			}			
		}
		
		// 출력
		if(end != null)
			System.out.println(visited[end.r][end.c][end.key] - 1);
		else
			System.out.println("-1");
	}

}

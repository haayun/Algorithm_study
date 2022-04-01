import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_달이_차오른다_가자2 {
	
	static class Point{
		int r, c, cnt, key;

		public Point(int r, int c, int cnt, int key) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
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
		boolean[][][] visited = new boolean[1<<6][N][M]; 
		queue.offer(new Point(sr, sc, 0, 0));
		visited[0][sr][sc] = true;
		
		int ans = -1;
		while(!queue.isEmpty()) {
			int cr = queue.peek().r, cc = queue.peek().c;
			int c_cnt = queue.peek().cnt, c_key = queue.peek().key;
			
			queue.poll();
			
			if(map[cr][cc] == '1') {
				ans = c_cnt;
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = cr + dr[i], nc = cc + dc[i];
				
				// 경계 체크, 벽 체크
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[c_key][nr][nc] || map[nr][nc] == '#') continue;
				
				// 문 체크 (통과할 수 있는지 확인)
				if(map[nr][nc] >= 'A' && map[nr][nc] <= 'F' && (c_key & 1<<(map[nr][nc] - 'A')) == 0) continue;
				
				int n_cnt = c_cnt + 1, n_key = c_key;
				if(map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
					n_key |= 1<<(map[nr][nc] - 'a');
				}
				
				queue.offer(new Point(nr, nc, n_cnt, n_key));
				visited[n_key][nr][nc] = true;
			}			
		}
		System.out.println(ans);
		
	}

}

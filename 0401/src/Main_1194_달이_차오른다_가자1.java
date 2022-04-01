import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_달이_차오른다_가자1 {
/*
 * 틀렸습니다.
 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		
		int[] dr = {0, 0, 1, -1};
		int[] dc = {1, -1, 0, 0};
		
		Point start = null;
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				if(map[i][j] == '0')
					start = new Point(i, j);
					
			}
		}
		
		Queue<Point> queue = new LinkedList<>();
		Point[][] visited = new Point[N][M]; // x : 이동 횟수, y : 열쇠
		queue.offer(start);
		visited[start.x][start.y] = new Point(0, 0);
		Point end = null;
		while(!queue.isEmpty()) {
			int cr = queue.peek().x, cc = queue.peek().y;
			queue.poll();
			
			if(map[cr][cc] == '1') {
				end = new Point(cr, cc);
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = cr + dr[i], nc = cc + dc[i];
				
				// 경계 체크, 벽 체크
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == '#') continue;
				
				if(map[nr][nc] >= 'A' && map[nr][nc] <= 'F' && (visited[cr][cc].y & 1<<(map[nr][nc] - 'A')) == 0) continue;
				
				if(visited[nr][nc] != null && visited[cr][cc].y == visited[nr][nc].y) continue;
				
				if(map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
					visited[nr][nc] = new Point(visited[cr][cc].x + 1, visited[cr][cc].y | 1<<(map[nr][nc] - 'a'));
				} else {
					visited[nr][nc] = new Point(visited[cr][cc].x + 1, visited[cr][cc].y); 
				}
				
				queue.offer(new Point(nr, nc));
			}			
		}
		if(end == null)
			System.out.println("-1");
		else
			System.out.println(visited[end.x][end.y].x);
		
	}

}

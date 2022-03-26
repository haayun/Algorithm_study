import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2638_치즈 {
/*
 * 메모리 43506
 * 시간 224
 */
	
	static int[][] board;
	static int N, M, cheese;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		cheese = 0;
		
		// 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1) cheese++;
			}
		}
		// 연산
		int ans = 0;
		
		while(cheese > 0) {
			melt();
			ans++;
		}
		
		// 출력
		System.out.println(ans);
	}
	
	
	
	static void melt() {
		int[][] temp = new int[N][M];
		
		// deep copy
		for(int i = 0; i <N; i++)
			for(int j = 0; j < M; j++)
				temp[i][j] = board[i][j];
		
		Queue<Point> queue = new LinkedList<>();
		temp[0][0] = -1;
		queue.offer(new Point(0, 0));
		
		// bfs : 외부 공기 -1로 표시 
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			for(int i =0; i < 4; i++) {
				int nr = cur.x + dr[i], nc = cur.y + dc[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || temp[nr][nc] != 0) continue;
				temp[nr][nc] = -1;
				queue.offer(new Point(nr, nc));
			}
		}
		
		// 치즈가 2변 이상이 외부 공기와 맞닿아 있으면 녹는다
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(temp[i][j] != 1) continue;
				int cnt = 0;		
				for(int d = 0; d < 4; d++) {
					int nr = i + dr[d], nc = j + dc[d];
					if(temp[nr][nc] == -1) cnt++;
				}
				
				if(cnt >= 2) {
					board[i][j] = 0;
					cheese--;
				}
			}
		}
	}
}

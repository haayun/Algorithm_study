import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_경주로_건설 {
// https://programmers.co.kr/learn/courses/30/lessons/67259
	
	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{0,0,0},{0,0,0},{0,0,0}}));
	}
	static class Point{
		int r, c, dir;

		public Point(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "[r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}
		
	}
	// 상 우 하 좌
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static int solution(int[][] board) {
		int answer = 0;
		
		int N = board.length;
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0, 1));
		queue.offer(new Point(0, 0, 2));
		board[0][0] = -1;
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			System.out.println(cur);
			if(cur.r == N - 1 && cur.c == N - 1) break;
			
			for(int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i], nc = cur.c = dc[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] == 1) continue;
				
				int price = -1;
				if(i != cur.dir) price -= 5;
				if(board[nr][nc] == 0 || board[nr][nc] < board[cur.r][cur.c] + price) {
					board[nr][nc] = board[cur.r][cur.c] + price;
					queue.offer(new Point(nr, nc, i));
				}
			}
		}
		
		for (int[] row : board) {
			System.out.println(Arrays.toString(row));
		}
		
		return answer;
	}
}

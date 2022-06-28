import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_아이템_줍기 {

	public static void main(String[] args) {
		System.out.println(
				solution(new int[][] { { 1, 1, 7, 4 }, { 3, 2, 5, 5 }, { 4, 3, 6, 9 }, { 2, 6, 8, 8 } }, 1, 3, 7, 8));
		System.out.println(
				solution(new int[][] { { 1, 1, 8, 4 }, { 2, 2, 4, 9 }, { 3, 6, 9, 8 }, { 6, 3, 7, 7 } }, 9, 7, 6, 1));
		System.out.println(solution(new int[][] { { 1, 1, 5, 7 } }, 1, 1, 4, 7));
		System.out.println(solution(new int[][] { { 2, 1, 7, 5 }, { 6, 4, 10, 10 } }, 3, 1, 7, 10));
		System.out.println(solution(new int[][] { { 2, 2, 5, 5 }, { 1, 3, 6, 4 }, { 3, 1, 4, 6 } }, 1, 4, 6, 3));
	}

	public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

		boolean[][] border = new boolean[101][101];

		for (int[] rect : rectangle) {
			for (int r = rect[1] * 2; r <= rect[3] * 2; r++) {
				for (int c = rect[0] * 2; c <= rect[2] * 2; c++) {
					border[r][c] = true;
				}
			}
		}
		
		for (int[] rect : rectangle) {
			for (int r = rect[1] * 2 + 1; r <= rect[3] * 2 - 1; r++) {
				for (int c = rect[0] * 2 + 1; c <= rect[2] * 2 - 1; c++) {
					border[r][c] = false;
				}
			}
		}

		Queue<Point> queue = new LinkedList<>();
		int[][] visited = new int[101][101];

		int cr = characterY * 2, cc = characterX * 2;
		int ir = itemY * 2, ic = itemX * 2;
		queue.offer(new Point(cr, cc));
		visited[cr][cc] = 1;


		int[] dr = { 1, 0, -1, 0 }, dc = { 0, 1, 0, -1 };

		while (!queue.isEmpty()) {
			cr = queue.peek().x;
			cc = queue.peek().y;
			queue.poll();

			if (cr == ir && cc == ic) break;

			for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i], nc = cc + dc[i];
				
				if (nr < 0 || nr > 100 || nc < 0 || nc > 100) continue;
				if (visited[nr][nc] != 0 || !border[nr][nc]) continue;
				
				queue.offer(new Point(nr, nc));
				visited[nr][nc] = visited[cr][cc] + 1;
			}

		}

		int answer = (visited[ir][ic] - 1) / 2;
		return answer;
	}

}

import java.util.Arrays;

public class Solution_행렬_테두리_회전하기 {

	public static void main(String[] args) {
//		int[] result = solution(6,	6, new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}});
		int[] result = solution(3,	6, new int[][]{{1, 1, 2, 2}});
		
		System.out.println(Arrays.toString(result));
	}

	static int[][] map;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		map = new int[rows + 1][columns + 1];
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++)
				map[i][j] = (i - 1) * rows + j;
		}
		for (int i = 0; i < queries.length; i++) {
			answer[i] = rotate(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
			for(int j = 1; j <= 3; j++) {
				System.out.println(Arrays.toString(map[j]));
			}
			System.out.println();
		}
		return answer;
	}

	static int rotate(int sr, int sc, int er, int ec) {
		int min = Integer.MAX_VALUE;
		int r = sr, c = sc;
		int d = 0;
		int cur = map[r][c];
		do {
			min = Math.min(min, cur);
			r += dr[d];
			c += dc[d];
			if (r < sr || r > er || c < sc || c > ec) {
				r -= dr[d];
				c -= dc[d];
				d = (d + 1) % 4;
				r += dr[d];
				c += dc[d];
			}
			int temp = map[r][c];
			map[r][c] = cur;
			cur = temp;
		} while (r != sr || c != sc);
		return min;
	}
}

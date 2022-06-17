import java.util.Arrays;

public class Solution_합승_택시_요금 {

	public static void main(String[] args) {
		System.out.println(solution(6, 4, 6, 2, new int[][] { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 },
				{ 5, 1, 24 }, { 4, 6, 50 }, { 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } }));
		System.out.println(
				solution(7, 3, 4, 1, new int[][] { { 5, 7, 9 }, { 4, 6, 4 }, { 3, 6, 1 }, { 3, 2, 3 }, { 2, 1, 6 } }));
		System.out.println(solution(6, 4, 5, 6, new int[][] { { 2, 6, 6 }, { 6, 3, 7 }, { 4, 6, 7 }, { 6, 5, 11 },
				{ 2, 5, 12 }, { 5, 3, 20 }, { 2, 4, 8 }, { 4, 3, 9 } }));

	}

	static int[][] graph;
	static final int INF = Integer.MAX_VALUE;

	public static int solution(int n, int s, int a, int b, int[][] fares) {

		graph = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i == j) graph[i][j] = 0;
				else graph[i][j] = INF;
			}
		}

		for (int i = 0; i < fares.length; i++) {
			int c = fares[i][0];
			int d = fares[i][1];
			int f = fares[i][2];
			graph[c][d] = graph[d][c] = f;
		}

		floydWarshall(n);

		int min = graph[s][a] + graph[s][b];
		for(int i = 1; i <= n; i++) {
			int tmp = graph[s][i] + graph[i][a] + graph[i][b];
			if(tmp < min) min = tmp;
		}
		
		return min;
	}

	static void floydWarshall(int N) {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (i == k)
					continue;
				for (int j = 1; j <= N; j++) {
					if (i == j || k == j)
						continue;
					int new_dist = graph[i][k] + graph[k][j];
					if (new_dist < graph[i][j]) {
						graph[i][j] = new_dist;
					}
				}
			}
		}
	}
}

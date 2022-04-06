import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5643_키_순서 {

	static int[][] graph;
	static int N;
	static final int INF = 9999999;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());

			graph = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					graph[i][j] = INF;
					if (i == j)
						graph[i][j] = 0;
				}
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				graph[a][b] = 1;
			}

			floydWarshall();

			int answer = 0;

			for (int i = 1; i <= N; i++) {
				boolean flag = true;
				for (int j = 1; j <= N; j++) {
					if (graph[i][j] >= INF && graph[j][i] >= INF) {
						flag = false;
						break;
					}
				}
				if (flag)
					answer++;
			}

			System.out.println("#" + tc + " " + answer);
		}

	}

	static void floydWarshall() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if(i == k) continue;
				for (int j = 1; j <= N; j++) {
					if(i==j || k==j) continue; 
					int new_dist = graph[i][k] + graph[k][j];
					if (new_dist < graph[i][j]) {
						graph[i][j] = new_dist;
					}
				}
			}
		}
	}

}

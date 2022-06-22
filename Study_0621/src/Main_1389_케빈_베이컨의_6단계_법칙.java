import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1389_케빈_베이컨의_6단계_법칙 {

	static int N, M;
	static int[][] graph;
	static int INF = 500001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					graph[i][j] = 0;
				else
					graph[i][j] = INF;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			graph[A][B] = graph[B][A] = 1;
		}
		floydWarshall();

		int kevin = 0;
		int min = INF * N;

		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) 
				sum += graph[i][j];
			
			if (sum < min) {
				min = sum;
				kevin = i;
			}
		}
		System.out.println(kevin);
	}

	static void floydWarshall() {
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

package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와_BFS_adjMatrix {

	static int N, M, V;
	static boolean[][] matrix;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()) + 1;
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		matrix = new boolean[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken());
			matrix[from][to] = true;
			matrix[to][from] = true;
		}
		
		dfs(V, new boolean[N]);
		System.out.println();
		bfs(V);

	}
	static void dfs(int current, boolean[] visited) {
		visited[current] = true;
		System.out.print(current +" ");
		
		for(int i =0; i <N; i++) {
			if(matrix[current][i] && !visited[i]) {
				dfs(i, visited);
			}
		}
	}
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N];

		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");

			for (int i = 0; i < N; i++) {
				if(matrix[current][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}

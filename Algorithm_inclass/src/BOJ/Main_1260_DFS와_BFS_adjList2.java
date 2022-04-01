package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와_BFS_adjList2 {

	static int N, M, V;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++)
			adjList[i] = new ArrayList<Integer>();

		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());

			adjList[from].add(to);
			adjList[to].add(from);
		}

		for (int i = 1; i <= N; i++)
			Collections.sort(adjList[i]);
		
		visited = new boolean[N + 1];
		dfs(V);
		System.out.println();
		bfs(V);

	}

	static void dfs(int current) {
		visited[current] = true;
		System.out.print(current + " ");

		for (Integer i : adjList[current]) {
			if (!visited[i]) {
				dfs(i);
			}
		}
	}

	static void bfs(int start) {
		visited = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");

			for (Integer i : adjList[current]) {
				if (!visited[i]) {
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
	}
}

package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와_BFS_adjList1 {

	static class Node{
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
		
	}

	static int N, M, V;
	static Node[] adjList;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()) + 1;
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		adjList = new Node[N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken());
			if(adjList[from] == null || adjList[from].vertex > to)
				adjList[from] = new Node(to, adjList[from]);
			else
				adjList[from].link = new Node(to, null);
			
			if(adjList[to] == null || adjList[to].vertex > from)
				adjList[to] = new Node(from, adjList[to]);
			else
				adjList[to].link = new Node(from, null);
		}
		
		dfs(V, new boolean[N]);
		System.out.println();
		bfs(V);

	}
	
	static void dfs(int current, boolean[] visited) {
		visited[current] = true;
		System.out.print(current +" ");
		
		for(Node temp = adjList[current]; temp != null; temp = temp.link) {
			if(!visited[temp.vertex])
				dfs(temp.vertex, visited);
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

			for(Node temp = adjList[current]; temp != null; temp = temp.link) {
				if(!visited[temp.vertex]) {
					queue.offer(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
		}
	}
}

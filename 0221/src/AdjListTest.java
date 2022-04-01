import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
7
8
0 1
0 2	
1 3
1 4
2 4
3 5
4 5
5 6	
*/

public class AdjListTest {

	static class Node {
		int vertex;
		Node link;

		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}

	}

	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 정점 수
		int C = sc.nextInt(); // 간선 수

		Node[] adjList = new Node[N];

		for (int i = 0; i < C; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			// 무향이므로 간선 하나로 양방향 처리

			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}

//		for (Node head : adjList) {
//			System.out.println(head);
//		}
		
		bfs(adjList, 0);
	}
	
	public static void bfs(Node[] adjList, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println(current);
			
			for(Node temp = adjList[current]; temp != null; temp = temp.link) {
				if(!visited[temp.vertex]) {
					queue.offer(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
		}
	}
	
	
	static void dfs(Node[] adjList, boolean[] visited, int current) {
		visited[current] = true;
		System.out.print(current);
		
		for(Node temp = adjList[current]; temp != null; temp = temp.link) {
			if(!visited[temp.vertex])
				dfs(adjList, visited, temp.vertex);
		}
	}

}

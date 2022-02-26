package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 실행 시간 : 109 ms
 * 메모리 : 19,388 kb
 */

public class Solution_1238_Contact {

	static class Node {
		int vertex;
		Node link;

		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
		
	}

	static Node[] graph;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		System.setIn(new FileInputStream("input (1).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			graph = new Node[101];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from] = new Node(to, graph[from]);
			}
			System.out.println("#" + tc + " " + bfs(V));

		}
	}

	static int bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		int[] visited = new int[101];
		Arrays.fill(visited, 0);

		queue.offer(start);
		visited[start] = 1;
		int last = 0;
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			
			for (Node temp = graph[current]; temp != null; temp = temp.link) {
				if (visited[temp.vertex] == 0) {
					queue.offer(temp.vertex);
					visited[temp.vertex] = visited[current] + 1;
					last = Math.max(last, visited[temp.vertex]);
				}
			}
		}
		int max = 0;
		for (int i = 1; i < 101; i++) {
			if (visited[i] == last) {
				max = Math.max(max, i);
			}
		}

		return max;

	}

}

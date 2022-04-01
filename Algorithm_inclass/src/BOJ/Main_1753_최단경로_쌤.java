package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_최단경로_쌤 {
	
	static class Node {
		int to, weight;
		Node next;

		public Node(int to, int weight, Node next) {
			this.to = to;
			this.weight = weight;
			this.next = next;
		}

	}

	static class Vertex implements Comparable<Vertex> {
		int no, totalDistance;

		public Vertex(int no, int totalDistance) {
			this.no = no;
			this.totalDistance = totalDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return this.totalDistance - o.totalDistance;
		}

	}

	static Node[] adjList;
	static int[] distance;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken()); // 정점 개수
		int E = Integer.parseInt(st.nextToken()); // 간선 개수
		int K = Integer.parseInt(br.readLine()); // 시작 정점

		adjList = new Node[V + 1];
		distance = new int[V + 1]; // 출발지에서 자신으로의 최소 비용
		visited = new boolean[V + 1]; // 최소 비용 확정 여부

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]);
		}

		// Dijkstra
		boolean[] visited = new boolean[V + 1]; // 최소 비용 확정 여부

		processShortDistance(K, V);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			sb.append(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]).append("\n");
		}
		System.out.println(sb);

	}

	static void processShortDistance(int start, int vCnt) {
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		pq.offer(new Vertex(start, 0));

		Vertex current;
		int cnt = 0;

		while (!pq.isEmpty()) {
			current = pq.poll(); // 미처리된 정점 중 시작정점에서 자신으로의 비용이 최소인 정점이 뽑힘.
									// (같은 정점의 시작점에서의 비용이 여러번 갱신되면 큐에 어려개 정보가 있다. ==> 따라서, 이미 처리된 정점이라면 )

			if (visited[current.no])
				continue;

			visited[current.no] = true;
			if (++cnt == vCnt)
				break;

			for (Node temp = adjList[current.no]; temp != null; temp = temp.next) {

				if (!visited[temp.to] && distance[temp.to] > current.totalDistance + temp.weight) {
					distance[temp.to] = current.totalDistance + temp.weight;
					pq.offer(new Vertex(temp.to, distance[temp.to]));
				}
			}

		}
	}

}

package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_최단경로_김하연  {

	static class Vertex implements Comparable<Vertex> {
		int no, minDistance;

		public Vertex(int no, int minDistance) {
			this.no = no;
			this.minDistance = minDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return this.minDistance - o.minDistance;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());	// 정점 개수 
		int E = Integer.parseInt(st.nextToken());	// 간선 개수 
		int K = Integer.parseInt(br.readLine());	// 시작 정점 

		ArrayList<Vertex>[] list = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++)
			list[i] = new ArrayList<Vertex>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list[Integer.parseInt(st.nextToken())]
					.add(new Vertex(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		// Dijkstra 
		int[] distance = new int[V+1];			// 출발지에서 자신으로의 최소 비용 
		boolean[] visited = new boolean[V+1];	// 최소 비용 확정 여부 
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[K] = 0;
		pq.offer(new Vertex(K, distance[K]));

		while (!pq.isEmpty()) {
			// 단계 1 : 최소비용이 확정되지 않은 정점 중 최소비용의 정점 선택 
			Vertex current = pq.poll();

			if (visited[current.no]) continue;

			visited[current.no] = true;
			
			
			// 단계 2 : 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른 정점의 최소비용을 고려 
			for(int i = 0; i < list[current.no].size(); i++) {
				Vertex v = list[current.no].get(i);		// 선택된 정점에서 갈 수 있는 정점  
				if(!visited[v.no] && distance[v.no] > distance[current.no] + v.minDistance) {
					distance[v.no] = distance[current.no] + v.minDistance;
					pq.offer(new Vertex(v.no, distance[v.no]));
				}
			}

		}
		for(int i = 1; i <= V; i++) {
			System.out.println(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]);
		}
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_3124_최소_스패닝_트리_Prim {
/*
 * 메모리 222,040 kb
 * 실행시간 3,065 ms
 */
	static class Edge implements Comparable<Edge> {
		int node;
		long weight;

		public Edge(int node, long weight) {
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return (int) (this.weight - o.weight);
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			ArrayList<Edge>[] graph = new ArrayList[V];
			
			for (int i = 0; i < V; i++)
				graph[i] = new ArrayList<Edge>();

			while (E-- > 0) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;
				long weight = Integer.parseInt(st.nextToken());
				
				graph[from].add(new Edge(to, weight));
				graph[to].add(new Edge(from, weight));
			}

			
			boolean[] visited = new boolean[V];
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.offer(new Edge(0, 0));
			
			long ans = 0;
			while(!pq.isEmpty()) {
				Edge cur = pq.poll();
				if(visited[cur.node]) continue;
				ans += cur.weight;
				visited[cur.node] = true;
				
				for (Edge edge : graph[cur.node]) {
					if(!visited[edge.node])
						pq.offer(edge);
				}
			}
			

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

}

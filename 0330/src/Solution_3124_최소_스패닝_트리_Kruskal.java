import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3124_최소_스패닝_트리_Kruskal {
/*
 * 메모리 122,756 kb
 * 실행시간 1,762 ms
 */
	static class Edge implements Comparable<Edge> {
		int from, to;
		long weight;

		public Edge(int from, int to, long weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return (int) (this.weight - o.weight);
		}

	}

	static boolean union(int x, int y) {
		int xp = findParent(x);
		int yp = findParent(y);

		if (xp == yp)
			return false;
		if (parent[xp] < parent[yp]) { // 새로운 루트 xp
			parent[xp] += parent[yp];
			parent[yp] = xp;
		} else { // 새로운 루트 yp
			parent[yp] += parent[xp];
			parent[xp] = yp;
		}
		return true;
	}

	static int findParent(int node) {
		if (parent[node] < 0)
			return node;
		return parent[node] = findParent(parent[node]);
	}

	static int[] parent;
	static Edge[] edgeList;

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

			parent = new int[V];
			for (int i = 0; i < V; i++)
				parent[i] = -1;

			edgeList = new Edge[E];

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;
				long weight = Integer.parseInt(st.nextToken());
				
				edgeList[i] = new Edge(from, to, weight);
			}
			
			Arrays.sort(edgeList);
			
			long ans = 0;
			int cnt = 0;
			
			for (Edge edge : edgeList) {
				if(union(edge.from, edge.to)) {	// union이 성공하면 (사이클이 아니면) 간선 연결
					ans += edge.weight;			// 가중치 더하기
					if(++cnt == V - 1) break;	// 간선은 V-1만큼 연결하면 MST 완성
				}
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		}
		System.out.println(sb);
	}

}

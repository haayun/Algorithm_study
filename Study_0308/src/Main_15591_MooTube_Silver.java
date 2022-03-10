import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15591_MooTube_Silver {

	static class Node {
		int vertex, weight;
		Node link;

		public Node(int vertex, int weight, Node link) {
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		Node[] adjList = new Node[N];
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken()) - 1;
			int q = Integer.parseInt(st.nextToken()) - 1;
			int r = Integer.parseInt(st.nextToken());
			
			adjList[p] = new Node(q, r, adjList[p]);
			adjList[q] = new Node(p, r, adjList[q]);
		}
	
		boolean[] visited;
		Queue<Integer> queue;
		
		while(Q-- > 0) {
			
			st = new StringTokenizer(br.readLine(), " ");
			int K = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken()) - 1;
			
			visited = new boolean[N];
			queue = new LinkedList<>();
			
			visited[V] = true;
			queue.offer(V);
			

			int ans = 0;
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				for(Node temp = adjList[cur]; temp != null; temp = temp.link) {
					if(!visited[temp.vertex] && temp.weight >= K) {
						ans++;
						queue.offer(temp.vertex);
						visited[temp.vertex] = true;
					}
				}
			}
			
			System.out.println(ans);
		}
		
	}

}

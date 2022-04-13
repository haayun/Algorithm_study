import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4386_별자리_만들기 {

	static class Edge implements Comparable<Edge>{
		int node;
		double weight;
		
		public Edge(int node, double weight) {
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return (int) (this.weight - o.weight);
		}
	}
	
	static class Star {
		double x, y;

		public Star(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static double dist(Star a, Star b) {
		return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Star[] stars = new Star[N];
		// 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			stars[i] = new Star(x, y);
		}
		
		double[][] adjMatrix = new double[N][N];
		
		// 인접행렬 생성
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				adjMatrix[i][j] = dist(stars[i], stars[j]);
			}
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N];
		
		pq.add(new Edge(0, 0));
		double answer = 0;
		
		// 프림 알고리즘 (MST)
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			int node = edge.node;
			double weight = edge.weight;
			
			if(visited[node]) continue;
			answer += weight;
			visited[node] = true;
			
			for(int i = 0; i < N; i++) {
				if(visited[i]) continue;
				pq.add(new Edge(i, adjMatrix[node][i]));
			}
		}
		
		// 출력
		System.out.printf("%.2f", answer);
	}

}

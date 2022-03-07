import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1774_우주신과의_교감2 {

	static class Edge implements Comparable<Edge> {
		int from, to;
		double weight;

		public Edge(int from, int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			if (this.weight < o.weight)
				return -1;
			return 1;
		}

	}

	static int[] parents;

	static int findSet(int x) {
        if (parents[x] == x) return x;
        else return parents[x] = findSet(parents[x]);
    }

	static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (a < b) {
			parents[bRoot] = aRoot;
		} else {
			parents[aRoot] = bRoot;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Point[] gods = new Point[N];
		parents = new int[N];

		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			gods[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			parents[i] = i;
		}

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				double xd = gods[i].x - gods[j].x;
				double yd = gods[i].y - gods[j].y;
				pq.offer(new Edge(i, j, Math.sqrt(xd * xd + yd * yd)));
			}
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1, b = Integer.parseInt(st.nextToken()) - 1;
			union(a, b);
		}

		int cnt = M;
		double sum = 0;

		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if(findSet(edge.from) != findSet(edge.to)) {
				sum += edge.weight;
				
				if(++cnt == N)
					break;
				
				union(edge.from, edge.to);
			}
		}

		System.out.printf("%.2f", sum);

	}
}

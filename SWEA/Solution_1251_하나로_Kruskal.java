package SWEA;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1251_하나로_Kruskal {
	
	static int N;
	static double E;
	static Point[] islands;
	static int[] parents;
	static Edge[] edgeList;
	
	static class Edge implements Comparable<Edge> {
//		Point from, to;
		int from, to;
		double weight;

		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Double.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		
	}

	static int findParent(int node) {
		if(node == parents[node])
			return node;
		return parents[node] = findParent(parents[node]);
	}

	static boolean union(int a, int b) {
		int aRoot = findParent(a);
		int bRoot = findParent(b);
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		System.setIn(new FileInputStream("input (2).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			islands = new Point[N];
			parents = new int[N];
			for(int i = 0; i<N; i++)
				islands[i] = new Point();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				islands[i].x = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				islands[i].y = Integer.parseInt(st.nextToken());
			}
			
			E = Double.parseDouble(br.readLine());

			int index = 0;
			edgeList = new Edge[N * (N-1) / 2];
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					double Lsq = Math.pow(islands[i].x - islands[j].x, 2) + Math.pow(islands[i].y - islands[j].y, 2);
					edgeList[index++] = new Edge(i, j, E * Lsq);
				}
			}
			
			Arrays.sort(edgeList);
			for (int i = 0; i < N; i++)
				parents[i] = i;
			int cnt = 0;
			double sum = 0;
			for (Edge edge : edgeList) {
				if(union(edge.from, edge.to)) {
					sum += edge.weight;
					if(++cnt == N - 1) break;
				}
			}

			System.out.println("#" + tc + " " + Math.round(sum));
		}
	}

}

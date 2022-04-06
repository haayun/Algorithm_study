import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1263_사람_네트워크2 {

	static int[][] graph;
	static int N;
	static final int INF = 9999999;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			graph = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
					if(graph[i][j] == 0 && i != j) graph[i][j] = INF;
				}
			}
			
			floydWarshall();
			int answer = Integer.MAX_VALUE;
			
			for(int i =0; i < N; i++) {
				int temp = 0;
				for(int j = 0; j < N; j++) 
					temp += graph[i][j];
				answer = Math.min(answer, temp);
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
	static void floydWarshall() {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if(i == k) continue;
				for (int j = 0; j < N; j++) {
					if(i==j || k==j) continue; 
					int new_dist = graph[i][k] + graph[k][j];
					if (new_dist < graph[i][j]) {
						graph[i][j] = new_dist;
					}
				}
			}
		}
	}

}

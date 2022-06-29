import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11403_경로_찾기 {

	static int N;
	static int[][] adjMatrix;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		adjMatrix = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(adjMatrix[i][j] == 0)
					bfs(i);
			}
		}
		
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				System.out.print(adjMatrix[i][j] + " ");
			System.out.println();
		}
	}

	static void bfs(int idx) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N];
		
		queue.offer(idx);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int i = 0; i < N; i++) {
				if(visited[i]) continue;
				if(adjMatrix[cur][i] == 1) {
					queue.offer(i);
					visited[i] = true;
					adjMatrix[idx][i] = 1;
				}
			}
		}
	}
	
}

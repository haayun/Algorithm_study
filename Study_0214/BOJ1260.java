import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {
static boolean[][] graph;
static boolean[] visited;
static int N, M;
static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()) + 1; M = Integer.parseInt(st.nextToken());
		int V= Integer.parseInt(st.nextToken());
		
		graph = new boolean[N][N];
		visited = new boolean[N];
		
		
		// 그래프에 간선 표시 
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			graph[a][b] = true; graph[b][a] = true;
		}
		// 연산  
		dfs(V);
		sb.append("\n");
		Arrays.fill(visited, false);
		bfs(V);
		
		// 출력    
		System.out.println(sb);
	}
	static void dfs(int V) {
		sb.append(V).append(" ");
		visited[V] = true;
		for(int i = 0; i < N; i++) {
			if(graph[V][i] == true && !visited[i]) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int V) {
		Queue<Integer> q = new LinkedList<>();
		visited[V] = true;
		q.offer(V);
		while(!q.isEmpty()) {
			int temp = q.poll();
			sb.append(temp).append(" ");
			for(int i = 0; i < N; i++) {
				if(graph[temp][i] == true && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}
	
}

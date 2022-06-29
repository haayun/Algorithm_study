import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16928_뱀과_사다리_게임 {

	static int[] move = new int[101];
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
				
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			move[x] = y;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			move[u] = v;
		}
		
		int answer = bfs();
		System.out.println(answer);
		
	}
	
	static int bfs() {
		Queue<Integer> queue = new LinkedList<>();
		int[] visited = new int[101];
		
		queue.offer(1);
		visited[1] = 1;
		
		while(!queue.isEmpty()) {
			
			int cur = queue.poll();
			if(cur == 100) break;
			
			for(int i = 1; i <= 6; i++) {
				int next = cur + i;
				if(next > 100) continue;
				if(move[next] > 0) next = move[next];
				if(visited[next] == 0 || visited[next] > visited[cur] + 1) {
					queue.offer(next);
					visited[next] = visited[cur] + 1;
				}
				
			}
			
		}
		return visited[100] - 1;
	}

}

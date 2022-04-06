import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17471_게리맨더링 {
	static int N;
	static int[] population;
	static ArrayList<Integer>[] graph;
	static boolean[] area, visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 입력
		N = Integer.parseInt(br.readLine());

		population = new int[N + 1];
		graph = new ArrayList[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			population[i] = Integer.parseInt(st.nextToken());

		int M = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			graph[i] = new ArrayList<Integer>();
			M = Integer.parseInt(st.nextToken());
			for (int j = 0; j < M; j++)
				graph[i].add(Integer.parseInt(st.nextToken()));
		}

		area = new boolean[N + 1]; // 2개 구역 구별
		visited = new boolean[N + 1];
		
		// 조합 (비트마스크)
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < 1 << N; i++) {
			for (int j = 0; j < N; j++) {
				area[j + 1] = (i & 1 << j) > 0;
			}
			
			if(getDiff() > answer) continue;

			Arrays.fill(visited, false);
			
			// 총 선거구 개수 세기
			int cnt = 0;
			for (int j = 1; j <= N; j++) {
				if (!visited[j]) {
					cnt++;
					dfs(j);
				}
			}
			// 선거구가 2개여야 함
			if(cnt == 2) {
				answer = Math.min(answer, getDiff());
			}
		}
		
		// 출력
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
	
	static int getDiff() {
		int first = 0, second = 0;
		
		for(int i = 1; i <= N; i++) {
			if(area[i]) 
				first += population[i];
			else
				second += population[i];
		}
		return Math.abs(first - second);
	}

	// 같은 선거구의 구역들과 연결
	static void dfs(int cur) {
		visited[cur] = true;
		for (Integer adj : graph[cur]) {
			if (area[cur] == area[adj] && !visited[adj])
				dfs(adj);
		}
	}

}

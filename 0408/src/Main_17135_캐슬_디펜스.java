import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17135_캐슬_디펜스 {

	static int N, M, D, answer = 0;
	static int[] archerC = new int[3];
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0, 0);
		System.out.println(answer);

	}

	static void comb(int cnt, int start) {
		if (cnt == 3) {
			answer = Math.max(answer, play());
			return;
		}

		for (int i = start; i < M; i++) {
			archerC[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	static int play() {
		int result = 0;
		int[][] copy = new int[N+1][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				copy[i][j] = map[i][j];
		}

		int archerR = N;

		while (archerR > 0) {
			
			// 가장 가까운, 가장 왼쪽 적 공격
			for(int i = 0; i < 3; i++) {
				bfs(copy, archerR, archerC[i]);
			}
			
			for(int i = 0; i < archerR; i++) {
				for(int j = 0; j <M; j++) {
					if(copy[i][j] == 2) {
						result++;
						copy[i][j] = 0;
					}
				}
			}
			
			for(int i = 0; i < M; i++) {
				copy[archerR - 1][i] = 0;
			}
			archerR--;
			
		}
		return result;
	}
	// 좌 상 우
	static int[] dr = {0, -1, 0};
	static int[] dc = {-1, 0, 1};
	static void bfs(int[][] map, int r, int c) {
		int[][] visited = new int[N+1][M];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(r * M + c);
		visited[r][c] = 1;
		
		while(!queue.isEmpty()) {
			
			int cr = queue.peek() / M, cc = queue.peek() % M;
			queue.poll();
			if(visited[cr][cc] > D + 1) continue;
			if(map[cr][cc] > 0) {
				map[cr][cc] = 2;
				break;
			}
			for(int i = 0; i < 3; i++) {
				int nr = cr + dr[i], nc = cc + dc[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] != 0) continue;
				queue.offer(nr * M + nc);
				visited[nr][nc] = visited[cr][cc] + 1;
			}
		}
	}
}

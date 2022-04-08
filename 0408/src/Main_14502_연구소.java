import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	static int N, M, Z = 0, V = 0, answer = 0;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[] walls = new int[3];
	static int[] blanks, virus;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		blanks = new int[N * M];
		virus = new int[10];		// 최대 10개
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {			// 빈 칸 위치 저장
					blanks[Z++] = i * M + j;					
				} else if (map[i][j] == 2) {	// 바이러스 위치 저장
					virus[V++] = i * M + j;
				}
			}
		}
		// 브루트포스 (모든 조합 다 해보기)
		comb(0, 0);
		System.out.println(answer);
		
	}
	static void comb(int cnt, int start) {
		if(cnt == 3) {	// 벽 3개 세우기
			answer = Math.max(answer, spreadVirus());
			return;
		}
		
		for(int i = start; i < Z; i++) {
			walls[cnt] = blanks[i];
			comb(cnt+1, i+1);
		}
		
	}
	
	// 바이러스 퍼뜨리기 & 남은 빈 칸 세기
	static int spreadVirus() {
		int result = Z - 3;		// 처음 빈 칸 개수 - 벽 세개
		int[][] copy = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				copy[i][j] = map[i][j];
			}
		}
		// 벽 세우기
		for(int i = 0; i < 3; i++) {
			int r = walls[i] / M, c = walls[i] % M;
			copy[r][c] = 1;
		}
		
		
		// bfs 탐색하며 바이러스 퍼뜨리기
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < V; i++) {
			queue.offer(virus[i]);
		}
		
		while(!queue.isEmpty()) {
			int r = queue.peek() / M, c = queue.peek() % M;
			queue.poll();
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i], nc = c + dc[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || copy[nr][nc] != 0) continue;
				
				copy[nr][nc] = 2;
				queue.offer(nr * M + nc);
				result--;	// 바이러스 퍼지면 빈 칸 감소
			}
		}
		
		return result;
	}
}

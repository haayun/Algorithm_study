import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20058_마법사_상어와_파이어스톰 {

	static int N, sqN;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][][] map;
	static int cur, next;	// map 스위칭 관련 변수
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		sqN = 1 << N;
		map = new int[2][sqN][sqN];
		cur = 0; next = 1;	

		// 입력
		for (int i = 0; i < sqN; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < sqN; j++) {
				map[0][i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		Queue<Point> minusIce = new LinkedList<>();
		
		// 파이어스톰 시전
		while(Q-- > 0) {
			int L = Integer.parseInt(st.nextToken());
			
			// 1. 부분 격자로 나눠서 90도 회전
			rotateAll(L);
			
			// 2. 얼음칸 3개 또는 그 이상과 인접해있지 않은 칸 -> 얼음 - 1
			for(int i = 0; i < sqN; i++) {
				for(int j = 0; j < sqN; j++) {
					int adjIce = 0;
					int nr, nc;
					for(int k = 0; k < 4; k++) {
						nr = i + dr[k];
						nc = j + dc[k];
						if(nr < 0 || nr >= sqN || nc < 0 || nc >= sqN) continue;
						if(map[cur][nr][nc] == 0) continue;
						adjIce++;
					}
					// 인접 얼음 칸이 3개 이상이면 패스
					if(adjIce >= 3) continue;
					else minusIce.offer(new Point(i, j));
				}
			}
			// 인접칸의 상태가 바뀌기 떄문에 큐에 저장해서 마지막에 반영
			while(!minusIce.isEmpty()) {
				int r = minusIce.peek().x;
				int c = minusIce.peek().y;
				minusIce.poll();
				if(map[cur][r][c] > 0)	// 이미 얼음이 없으면 넘어감
					map[cur][r][c]--;
			}
		}
		
		// 출력 : 남아있는 얼음의 합
		int total = 0;
		for(int i = 0; i < sqN; i++) {
			for(int j = 0; j < sqN; j++) {
				total += map[cur][i][j];
			}
		}
		System.out.println(total);
		
		// 출력 : 가장 큰 덩어리가 차지하는 칸의 개수
		// 덩어리 마다 칸 개수 세고 최댓값 갱신
		int max = 0;
		for(int i = 0; i < sqN; i++) {
			for(int j = 0; j < sqN; j++) {
				if(map[cur][i][j] == 0) continue;
				max = Math.max(max, dfs(i, j));
			}
		}
		System.out.println(max);
	}
	
	static int dfs(int r, int c) {
		map[cur][r][c] = 0;
		int cnt = 1;
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i], nc = c + dc[i];
			if(nr < 0 || nr >= sqN || nc < 0 || nc >= sqN) continue;
			if(map[cur][nr][nc] == 0) continue;
			map[cur][nr][nc] = 0;
			cnt += dfs(nr, nc);
		}
		return cnt;
	}
	
	
	static void rotateAll(int L) {
		// 2^L * 2^L 부분 격자로 나누기
		int sqL = 1 << L;
		for(int i = 0; i < sqN; i += sqL) {
			for(int j = 0; j < sqN; j += sqL) {
				rotate(i, j, sqL);
			}
		}
		// 현재 가리키는 map 인덱스 교체
		int temp = cur;
		cur = next;
		next = temp;
	}
	
	static void rotate(int r, int c, int sqL) {
		// 시계방향 90도 회전
		int size = sqL - 1;
		for(int i = 0; i < sqL ; i++) {
			for(int j = 0; j < sqL ; j++) {
				map[next][r + j][c + size - i] = map[cur][r + i][c + j];
			}
		}
	}
	
}

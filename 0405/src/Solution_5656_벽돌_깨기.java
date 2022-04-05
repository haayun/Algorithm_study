import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌_깨기 {

	static int N, W, H, marbleCnt, answer;
	static int[] p, width;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] board, copy;
	static Queue<Point> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			p = new int[N];
			width = new int[W];
			board = new int[H][W];
			copy = new int[H][W];

			for (int i = 0; i < W; i++)
				width[i] = i;

			marbleCnt = 0;
			answer = Integer.MAX_VALUE;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if(board[i][j] > 0) marbleCnt++;
				}
			}
			perm(0);
			queue.clear();
			System.out.println(answer);
			sb.append("#").append(tc).append(" ").append("\n");
		}
	}

	static int dropMarble() {
		
		int cnt = marbleCnt;
		for(int i = 0; i < N; i++) {
			// 구슬에 맞은 벽돌을 큐에 넣고
			for(int j = 0; j < H; j++) {
				if(copy[j][p[i]] != 0) {
					queue.offer(new Point(j, p[i]));
					copy[j][p[i]] = 0;
					cnt--;
					break;
				}
			}
			
			
			// 반복적으로 큐가 빌 때까지 범위 내 벽돌들을 큐에 넣음 (1 이상) 
			while(!queue.isEmpty()) {
				
				if(cnt == 0) break;
				
				Point cur = queue.poll();
				for(int j = 1; j < copy[cur.x][cur.y]; j++) {
					for(int k = 0; k < 4; k++) {
						int nr = cur.x + dr[k] * j, nc = cur.y + dc[k] * j;
						if(nr < 0 || nr >= H || nc < 0 || nc >= W || copy[nr][nc] == 0) continue;
						
						queue.offer(new Point(nr, nc));
						copy[nr][nc] = -1;
					}
				}
			}
			
			for (int[] is : copy) {
				for(int j = 0; j < W; j++) {
					if(is[j] == -1) {
						is[j] = 0;
						cnt--;
					}
				}
				
			}
			
			// 벽돌 삭제 후 남은 벽돌 떨어뜨리기
			if(cnt > 0)
				dropBlock();
			// 남은 벽돌이 있다면 계속, 아니면 브레이크
			else break;
		}
		return cnt;
	}
	
	static void dropBlock() {
		for(int i = 0; i < W; i++) {
			for(int j = H - 1; j > 0; j--) {
				if(copy[j][i] == 0) {
					copy[j][i] = copy[j-1][i];
					copy[j-1][i] = 0;
				}
			}
		}
		
	}
	
	static void copy() {
		for(int i = 0; i < H; i++) {
			for(int j= 0; j < W; j++)
				copy[i][j] = board[i][j];
		}
	}
	
	static void perm(int cnt) {
		if (cnt == N) {
			copy();
			answer = Math.min(answer, dropMarble());
			return;
		}

		for (int i = 0; i < W; i++) {
			p[cnt] = width[i];
			perm(cnt + 1);
		}
	}

}

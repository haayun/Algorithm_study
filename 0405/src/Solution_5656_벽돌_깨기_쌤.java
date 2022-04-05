import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌_깨기_쌤 {

	static int N, W, H, min;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Point{
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("sample_input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			int[][] map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			
			go(0, map);
			
			System.out.println("#" + tc + " " + min);
		}
	}
	
	static boolean go(int count, int[][] map) {	// 중복순열 이용하여 구슬 던지기
		
		int result = getRemain(map);
		
		if(result == 0) {	// 모든 벽들이 다 부서졌다면
			min = 0;
			return true;
		}
		
		if(count == N) {	// 모든 구슬 다 던졌다면
			min = Math.min(min, result);
			return false;
		}
		
		int[][] newMap = new int[H][W];
		
		// 0 ~ W-1 열까지 구슬 던져보기
		for(int c = 0; c < W; c++) {
			
			// 구슬에 맞는 벽돌 찾기
			int r = 0;
			while(r < H && map[r][c] == 0) ++r;
			
			// 해당 열에 벽돌 없음
			if(r == H) continue;
			
			// 배열의 상태 백업
			copy(map, newMap);			
			
			// 현재 벽돌 기준으로 주변 가능한 벽돌 연쇄 처리
			boom(newMap, r, c);
			
			// 부서진 벽돌 처리
			down(newMap);
			
			// 다음 구슬 던지러 go
			if(go(count+1, newMap)) return true;
		}
		return false;
	}
	
	static void boom(int[][] map, int r, int c) {	// r, c 위치에서 주변의 가능한 모든 벽돌도 함께 부수는 처리
		Queue<Point> queue = new LinkedList<>();
		if(map[r][c] > 1) {
			queue.offer(new Point(r, c, map[r][c]));
		}
		map[r][c] = 0;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = p.r, nc = p.c;
				for(int k = 1; k < p.cnt; k++) {
					nr += dr[d];
					nc += dc[d];
					if(nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
					if(map[nr][nc] > 1) {
						queue.offer(new Point(nr, nc, map[nr][nc]));
					}
					map[nr][nc] = 0;	// 빈 공간이면 그냥 0, 벽돌이면 제거 처리
									
				}
			}
		}
	}
	
	static ArrayList<Integer> list = new ArrayList<>();
	static void down(int[][] map) {	// 부서진 벽돌 정리
		for(int c = 0; c < W; c++) {
			int r = H - 1;
			while(r >= 0) {
				if(map[r][c] > 0) {
					list.add(map[r][c]);
					map[r][c] = 0;
				}
				r--;
			}
			r = H - 1;
			for(int a : list) {
				map[r--][c] = a;
			}
			list.clear();
		}
	}
	
	static int getRemain(int[][] map) {
		int count = 0;
		for(int r = 0; r < H; r++) {
			for(int c = 0; c < W; c++) {
				if(map[r][c] > 0) ++count;
			}
		}
		return count;
	}
	
	static void copy(int[][] map, int[][] newMap) {
		for(int r = 0; r < H; r++) {
			for(int c = 0; c < W; c++)
				newMap[r][c] = map[r][c];
		}
	}
}

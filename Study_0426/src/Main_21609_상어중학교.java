import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_21609_상어중학교 {
	
	static class Point implements Comparable<Point>{
		int total, rainbow;
		int r, c;
		Point(int total, int rainbow, int r, int c){
			this.total = total;
			this.rainbow = rainbow;
			this.r = r;
			this.c = c;
		}
		@Override
		public int compareTo(Point o) {
			if(this.total != o.total)
				return this.total - o.total;
			if(this.rainbow != o.rainbow)
				return this.rainbow - o.rainbow;
			if(this.r != o.r)
				return this.r - o.r;
			return this.c - o.c;
		}
	}
	
	static int N, M, score;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		// 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		score = 0;
		while(true) {
			// autoplay
			
			// 1. 크기 가장 큰 블록 그룹 찾기 + 2. 1에서 찾은 그룹의 모든 블록 제거하기
			if(!largestBlock()) break;
			// 3. 중력 작용
			applyGravity();
			// 4. 반시계 회전
			rotate();
			// 5. 중력 작용
			applyGravity();
		}
		// 출력
		System.out.println(score);
		
	}
	
	// 그룹 만들기 (크기, 무지개 블록 개수, 기준 블록 위치 반환)
	static Point dfs(int r, int c, int m, int[][] map, int index) {
		int total = 1, rainbow = 0;
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i], nc = c + dc[i];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;	// 경계 체크
			if(map[nr][nc] == 0 || map[nr][nc] == m) {	// 그룹은 같은 색, 무지개색만 가능 
				if(map[nr][nc] == 0) rainbow++;
				map[nr][nc] = index;
				Point next = dfs(nr, nc, m, map, index);
				total += next.total;
				rainbow += next.rainbow;
			}
		}
		return new Point(total, rainbow, r, c);
	}
	
	static boolean largestBlock() {
		int[][] finalMask = new int[N][N];	// 가장 큰 블록그룹을 저장할 이차원 배열
		int finalIndex = 0;					// 블록 그룹을 구분짓는 숫자
		Point standard = new Point(0, 0, -1, -1);
		for(int m = 1; m <= M; m++) {	// 중복 연산 피하기 위해 같은 색끼리 dfs 돌리기
			int index = m * 10;			// mask에 채울 숫자 (같은 색이라도 그룹을 구분하기 위해)
			
			int[][] mask = new int[N][N];
			for(int i = 0; i < N; i++)
				mask[i] = map[i].clone();
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(mask[i][j] == m) {
						mask[i][j] = ++index;
						Point cur = dfs(i, j, m, mask, index);
					
						// 크기 > 무지개 블록 수 > 행 > 열 우선순위대로 비교
						if(standard.compareTo(cur) < 0) {	// 현재 그룹이 더 크다면 
							standard = cur;
							finalMask = mask;
							finalIndex = index;
						}
					}
				}
			}
		}
		// 크기가 2 미만이면 오토플레이 그만두도록 false 반환
		if(standard.total < 2) return false;
		
		// 2. 해당 블록 그룹의 모든 블록 제거 (색은 최대 5까지니까 6으로 채우기)
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(finalMask[i][j] == finalIndex)
					map[i][j] = 6;
			}
		}
		// 점수 획득
		score += Math.pow(standard.total, 2);
		return true;
	}
	
	static void applyGravity() {
		Stack<Integer> stack = new Stack<>();
		int black;
		for(int j = 0; j < N; j++) {
			for(int i = 0; i < N; i++) {
				if(map[i][j] == -1) {	// 검은 블록은 중력 작용 X, 이전의 블록들 stack에서 꺼내서 가까운 순으로 대입
					black = i;
					while(!stack.isEmpty()) {
						map[--black][j] = stack.pop();
					}
				}
				// 무지개 + 일반 블록은 이동하고 빈 칸(6)으로 채우기
				else if(map[i][j] != 6) {
					stack.push(map[i][j]);
					map[i][j] = 6;
				}
			}
			// 경게를 만나면 꺼내어 대입
			black = N;
			while(!stack.isEmpty()) {
				map[--black][j] = stack.pop();
			}
			
		}
	}
	
	static void rotate() {
		// 90도 반시계 회전
		int[][] after = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				after[N - 1 - j][i] = map[i][j];
			}
		}
		map = after;
	}
}

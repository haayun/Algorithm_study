import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_20056_마법사_상어와_파이어볼 {

	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static int N, M;
	static ArrayList<Integer>[][] map;
	static ArrayList<FireBall> fireBalls;
	
	static class FireBall {
		int r, c, m, s, d;
		boolean is_remain = true;
		public FireBall(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
	
		map = new ArrayList[N][N];
		fireBalls = new ArrayList<>();
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				map[i][j] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			fireBalls.add(new FireBall(r, c, m, s, d));
		}
		
		while(K-- > 0) {
		
			// 1. 이동
			for(int i = 0; i < fireBalls.size(); i++) {
				if(fireBalls.get(i).is_remain)
					moveFireBall(i);
			}
			
			// 2. 여러 파이볼이 있는 칸 처리
			for(int i = 0; i < N; i++) {
				for(int j = 0;j < N; j++) {
					if(map[i][j].size() < 2) continue;
					splitFireBall(i, j);
				}
			}
			
			// 맵 다시 비우기
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					map[i][j].clear();
			
		}
		int answer = 0;
		for (FireBall fb : fireBalls) {
			if(fb.is_remain)
				answer += fb.m;
		}
		System.out.println(answer);
		
	}
	
	
	static void splitFireBall(int r, int c) {
		int addS = 0, addM = 0;
		int even = 0, odd = 0;
		int size = map[r][c].size();
		// 합치기
		for (int i : map[r][c]) {
			FireBall cur = fireBalls.get(i);
			cur.is_remain = false;
			addS += cur.s;
			addM += cur.m;
			if(cur.d % 2 == 0) even++;
			else odd++;
		}
		
		addS /= size;
		addM /= 5;
		
		if(addM == 0) return;
		
		// 나누기
		if(even == 0 || odd == 0) {
			for(int i = 0; i <= 6; i += 2) {
				fireBalls.add(new FireBall(r, c, addM, addS, i));
			}
		} else {
			for(int i = 1; i <= 7; i += 2) {
				fireBalls.add(new FireBall(r, c, addM, addS, i));
			}
		}
	}
	
	static void moveFireBall(int idx) {
		FireBall cur = fireBalls.get(idx);
		
		int row = (cur.r + (cur.s * dr[cur.d])) % N;
		int col = (cur.c + (cur.s * dc[cur.d])) % N;
		
		if(row < 0) row += N;
		if(col < 0) col += N;
		
		map[row][col].add(idx);
		fireBalls.get(idx).r = row;
		fireBalls.get(idx).c = col;
	}
}

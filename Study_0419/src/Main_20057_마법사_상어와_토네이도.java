import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20057_마법사_상어와_토네이도 {

	static int N;
	static int[][] map;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {-1, 0, 1, 0};
	
	// 하드코딩 그자체...^^zzㅋㅋㅋㅋㅋ
	static int[][][] spread = {{{-1, 1}, {1, 1}, {-2, 0}, {2, 0}, {-1, 0}, {1, 0}, {-1, -1}, {1, -1}, {0, -2}, {0, -1}},
								{{-1, -1}, {-1, 1}, {0, -2}, {0, 2}, {0, -1}, {0, 1}, {1, -1}, {1, 1}, {2, 0}, {1, 0}},
								{{-1, -1}, {1, -1}, {-2, 0}, {2, 0}, {-1, 0}, {1, 0}, {-1, 1}, {1, 1}, {0, 2}, {0, 1}},
								{{1, -1}, {1, 1}, {0, -2}, {0, 2}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {-2, 0}, {-1, 0}}};
	static int[] percentage = {1, 1, 2, 2, 7, 7, 10, 10, 5, 0};
	static int p;	// 비율 칸 개수
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		p = percentage.length;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		int tr = N/2, tc = N/2;
		// 달팽이처럼 회오리로 움직이기 
		outer : for(int i = 1; i <= N; i++) {
			int dir = 0;
			if(i % 2 == 0) dir += 2; 
			
			for(int j = 0; j < 2; j++, dir++) {
				for(int k = 0; k < i; k++) {
					tr += dr[dir];
					tc += dc[dir];
					
					answer += blow(tr, tc, dir);
					if(tr == 0 && tc == 0) break outer;
				}
			}
		}
		System.out.println(answer);
		
	}

	static int blow(int r, int c, int dir) {
		
		int out = 0, alphaElse = 0, percent, spread_sand;
		int cr, cc;
		int sand = map[r][c];
		// 비율이 정해진 칸
		for(int i = 0; i < p - 1; i++) {
			cr = r + spread[dir][i][0];
			cc = c + spread[dir][i][1];
			percent = percentage[i];
			spread_sand = sand * percent / 100;
			if(cr < 0 || cr >= N || cc < 0 || cc >= N) 
				out += spread_sand;
			else 
				map[cr][cc] += spread_sand;
			
			alphaElse += spread_sand;
		}
		// 알파가 적힌 칸
		cr = r + spread[dir][p-1][0];
		cc = c + spread[dir][p-1][1];
		spread_sand = sand - alphaElse;
		if(cr < 0 || cr >= N || cc < 0 || cc >= N)
			out += spread_sand;
		else
			map[cr][cc] += spread_sand;
		
		map[r][c] = 0;
		
		return out;
	}
	
}

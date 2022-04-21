import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20057_마법사_상어와_토네이도 {

	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {-1, 0, 1, 0};
	
	static int[][][] spread = new int[4][5][5];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int tr = N/2, tc = N/2;
		int dir = 0;
		int moves = 1;
		int cnt = 0;
		int answer = 0;
		while(tr != 0 || tc != 0) {
			for(int i = 0; i < moves; i++) {
				answer += blow(int r, int c, int dir);
			}
			
			cnt++; dir++;
			if(dir == 4) dir = 0; 
			if(cnt == 2) {
				cnt = 0;
				moves++;
			}
		}
		
		
	}

	static int blow(int r, int c, int dir) {
		
	}
	
}

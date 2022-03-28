import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_24725_엠비티아이 {

	static char[][] MBTI = { { 'E', 'I' }, { 'N', 'S' }, { 'F', 'T' }, { 'P', 'J' } };
	static char[][] board;
	static int N, M;
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		for(int i =0;i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j< M; j++) {
				if(board[i][j] == MBTI[0][0] || board[i][j] == MBTI[0][1]) {
					for(int d = 0; d < 8; d++) {
						if(dfs(i, j, d, 0)) cnt++;
					}
				}
				
			}
		}
		System.out.println(cnt);
		
	}

	public static boolean dfs(int r, int c, int dir, int mbti) {
		if(mbti == 3) return true;
		
		int nr = r + dr[dir], nc = c + dc[dir];
		if (nr < 0 || nr >= N || nc < 0 || nc >= M)
			return false;
		if (board[nr][nc] != MBTI[mbti + 1][0] && board[nr][nc] != MBTI[mbti + 1][1])
			return false;

		return dfs(nr, nc, dir, mbti + 1);
	}

}

package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 메모리 : 12428	
 * 시간 : 940	
 */
public class Main_1987_알파벳_김하연  {
	static int ans = 1, temp, R, C;
	static int d[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] board;
	static boolean alphabet[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][];
		alphabet = new boolean[26];
		ans = 0;
		
		// 입력  
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		// 연산  
		dfs(0, 0, 1);
		
		// 출력  
		System.out.println(ans);
	}

	static void dfs(int r, int c, int dist) {
		// 백트래킹 퇴각 조건  
		if (alphabet[board[r][c] - 'A']) return;
		
		alphabet[board[r][c] - 'A'] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + d[i][0], nc = c + d[i][1];
			if (nr < 0 || nr >= R || nc < 0 || nc >= C)
				continue;
			dfs(nr, nc, dist + 1);
		}
		
		alphabet[board[r][c] - 'A'] = false;
		
		ans = Math.max(ans, dist);

	}
}

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_2578_빙고 {

	static boolean[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		board = new boolean[5][5];
		HashMap<Integer, Point> map = new HashMap<>();
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map.put(Integer.parseInt(st.nextToken()), new Point(i, j));
			}
		}

		int answer = 0;
		boolean flag = false;
		
		// 사회자가 번호를 부를 때 빙고 확인
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int mc = Integer.parseInt(st.nextToken());
				Point cur = map.get(mc);
				board[cur.x][cur.y] = true;
				if(!flag && i * 5 + j >= 10) {
					flag = bingo();
					answer = i * 5 + j;
				}
			}
		}
		System.out.println(answer + 1);

		
	}

	static boolean bingo() {
		int cnt = 0;
		int  d1 = 0, d2 = 0;
		for(int i = 0; i < 5; i++) {
			int r = 0, c = 0;
			for(int j = 0; j < 5; j++) {
				if(board[i][j]) r++;
				if(board[j][i]) c++;
			}
			if(r == 5) cnt++;
			if(c == 5) cnt++;
			
			if(board[i][i]) d1++;
			if(board[i][4-i]) d2++;
			
		}
		if(d1 == 5) cnt++;
		if(d2 == 5) cnt++;
		
		if(cnt >= 3) return true;
		return false;
		
	}
}

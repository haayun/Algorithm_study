

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2580_스도쿠 {
	
	static class Point{
		int r, c;
		Point(int r, int c){
			this.r = r;
			this.c = c;
		}
	}

	static boolean[][] candidate;
	static ArrayList<Point> empty = new ArrayList<>();
	static int[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		board = new int[9][9];
		for (int i = 0; i < 9; i++) {
//			String line = br.readLine();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
//				board[i][j] = line.charAt(j) - '0';
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 0) {
					empty.add(new Point(i, j));
				}
			}
		}
		
		candidate = new boolean[empty.size()][10];
		
		fillSudoku(0);
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	static boolean done = false;
	static void fillSudoku(int cnt) {
		if(cnt == empty.size()) {
			done = true;
			return;
		}
		int r = empty.get(cnt).r, c = empty.get(cnt).c;
		if(!getCandidate(r, c, cnt)) return;
		for(int i = 1; i <= 9; i++) {
			if(candidate[cnt][i]) {
				board[r][c] = i;
				fillSudoku(cnt+1);
				if(done) return;
				board[r][c] = 0;
			}
		}
		
	}
	
	static boolean getCandidate(int r, int c, int cnt) {
		Arrays.fill(candidate[cnt], true);
		for(int i = 0; i < 9; i++) {
			// 가로 체크
			candidate[cnt][board[r][i]] = false;
			// 세로 체크
			candidate[cnt][board[i][c]] = false;
		}
		Point start = getGrid(r, c);
		for(int i = start.r; i < start.r + 3; i++) {
			for(int j = start.c; j < start.c + 3; j++) {
				if(board[i][j] == 0) continue;
				candidate[cnt][board[i][j]] = false;
			}
		}
		return check(cnt);
		
	}
	
	static boolean check(int cnt) {
		boolean flag = false;
		for(int i = 1; i <= 9; i++) {
			flag |= candidate[cnt][i];
		}
		return flag;
	}
	
	static Point getGrid(int r, int c) {
		Point start = new Point(0, 0);
		for(int i = 3; i <= 9; i += 3) {
			if(r >= i) start.r = i;
			if(c >= i) start.c = i;
		}
		return start;
	}
	
}

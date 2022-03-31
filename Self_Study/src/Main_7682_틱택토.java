import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_7682_틱택토 {
	static StringBuilder sb = new StringBuilder();
	static char[][] board;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		while(true) {
			String s = br.readLine();
			if(s.equals("end")) break;
			
			int x = 0, o = 0;
			board = new char[3][3];
			for(int i = 0; i < 3; i++) {
				board[i] = s.substring(i * 3, i * 3 + 3).toCharArray();
				for(int j = 0; j < 3; j++) {
					if(board[i][j] == 'X') x++;
					else if (board[i][j] == 'O') o++;
				}				
			}
			
			if(x > o) {
				
			} else if (x == o) {
				
			} else {
				invalid();
			}
			
		}
	}
	
	public static boolean oWin() {
		return false;
		
	}
	
	
	public static void invalid() {
		sb.append("invalid\n");
	}
	public static void valid() {
		sb.append("valid\n");
	}
	
}

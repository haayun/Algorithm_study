import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1018 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//입력
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		char[][] board = new char[N][M];
		for(int i = 0; i < N; i++) 
			board[i] = br.readLine().toCharArray();
		
		//구현
		int min = Integer.MAX_VALUE;		
		for(int i = 0; i <= N-8; i++) {
			for(int j = 0; j <= M-8; j++) {
				int cnt = change(i, j, board);
				if(min > cnt)
					min = cnt;
			}
		}
		
		//출력
		System.out.println(min);
	}
	
	public static int change(int r, int c, char[][] board) {
		int cnt = 0;
		for(int i = 0; i < 8; i++) {		//행 변화값
			for(int j = 0; j < 8; j++) {	//열 변화값
				//행 변화값 + 열 변화값이 짝수면 시작색(B)과 동일해야 함
				if((i+j)%2 == 0 && board[r + i][c+j] !='B')
					cnt++;
				//행 변화값 + 열 변화값이 홀수라면 시작색과 반대색(W)이어야 함
				else if((i +j)%2 > 0 && board[r + i][c + j] != 'W')
					cnt++;
			}
		}
		if(cnt > 32)
			cnt = 64 - cnt;
		return cnt > 32 ? 64 - cnt : cnt;
	}
}

import java.util.Scanner;

public class NQueenBackTrackingTest {

	// 배열 1차원으로 -> 인덱스 = 행 

	static int N, ans;
	static int col[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ans = 0;
		col = new int[N + 1];
		setQueen(1);
		System.out.println(ans);

	}

	public static void setQueen(int rowNo) {	// rowNo : 퀸을 두어야하는 현재 행 
		
//		if(!isAvailable(rowNo-1)) return;	// 직전까지의 상황이 유망하지 않다면 리턴 
		
		// 기본파트
		if(rowNo > N) {
			ans++;
			return;
		}
		
		// 1열부터 - n열까지 퀸을 놓는 시도
		for (int i = 1; i <= N; i++) {
			col[rowNo] = i;
			if(isAvailable(rowNo)) {
				setQueen(rowNo + 1);				
			}
		}

	}
	
	public static boolean isAvailable(int rowNo) {	// rowNo : 놓아진 마지막 퀸 

		for (int i = 1; i < rowNo; i++) {
			//  체크, 대각선 체크 
			if(col[rowNo] == col[i] || rowNo-i == Math.abs(col[rowNo] - col[i])) return false; 
		}
		
		return true;
		
	}
}

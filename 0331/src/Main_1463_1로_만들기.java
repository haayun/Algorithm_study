import java.util.Scanner;

public class Main_1463_1로_만들기 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] memo = new int[N+1];
		memo[0] = memo[1] = 0;
		for(int i = 2; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			if(i % 3 == 0 && memo[i/3] + 1 < min) min = memo[i/3] + 1;
			if(i % 2 == 0 && memo[i/2] + 1 < min) min = memo[i/2] + 1;
			if(i >= 1 && memo[i - 1] + 1 < min) min = memo[i-1] + 1;
			
			memo[i] = min;
		}
		
		System.out.println(memo[N]);
	}
}

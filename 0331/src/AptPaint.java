import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class AptPaint {

	static int[] memo;
	
	static int fibo(int n) {
		if(n >= 2 && memo[n] == 0)
			memo[n] = fibo(n-1) +fibo(n-2);
		return memo[n];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt() - 1;
		memo = new int[n+1];
		
		memo[0] = 2;
		memo[1] = 3;
		for (int i = 0; i < n+1; i++) {
			System.out.println(fibo(i));
		}
	}

}

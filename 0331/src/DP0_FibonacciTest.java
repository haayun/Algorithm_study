import java.util.Arrays;
import java.util.Scanner;

public class DP0_FibonacciTest {

	private static long[] callCnt1, callCnt2, memo;
	private static long totalCnt1, totalCnt2;

	public static long fibo1(int n) {
		callCnt1[n]++;
		totalCnt1++;
		if (n < 2)
			return n;
		return fibo1(n - 1) + fibo1(n - 2);
	}

	public static long fibo2(int n) {
		callCnt2[n]++;
		totalCnt2++;
//		if (n >= 2 && memo[n] == 0) {	// 메모 여부 확인
		if(memo[n] == -1) {
			memo[n] = fibo2(n - 1) + fibo2(n - 2);
		}
		return memo[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		callCnt1 = new long[n + 1];
		callCnt2 = new long[n + 1];
		memo = new long[n + 1];		// 0으로 자동 초기화
		Arrays.fill(memo, -1);
		memo[0] = 0;
		memo[1] = 1;

		System.out.println(fibo2(n));
		for (int i = 0; i < n + 1; i++) {
			System.out.println("fibo2(" + i + ") : " + callCnt2[i]);
		}
		System.out.println("totalCnt2 : " + totalCnt2);
		System.out.println("==========================");
		System.out.println(fibo1(n));
		for (int i = 0; i < n + 1; i++) {
			System.out.println("fibo1(" + i + ") : " + callCnt1[i]);
		}
		System.out.println("totalCnt1 : " + totalCnt1);
	}

}

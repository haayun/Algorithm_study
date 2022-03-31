import java.util.Scanner;

public class DP2_MinCoinChangeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int[] D = new int[money + 1];
		D[0] = 0;	// 0원을 만드는 최소동전개수는 0
		for (int i = 0; i <= money; i++) {
			// 1, 4, 6원을 각각 사용했을 때의 최소 동전 개수 중 가장 최적해 (최소값)
			int min = Integer.MAX_VALUE;
			if(i >= 1 && D[i-1] + 1 < min) min = D[i-1] + 1;
			if(i >= 4 && D[i-4] + 1 < min) min = D[i-4] + 1;
			if(i >= 6 && D[i-6] + 1 < min) min = D[i-6] + 1;
			
			D[i] = min;
		}
		System.out.println(D[money]);
	}

}

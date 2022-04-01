package BOJ;

import java.util.Scanner;

/*
 * 쌤 풀이 
 */
public class BOJ2839_2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int weight = 0, ans = -1;
		
		/*
		 * 봉지 수를 줄이려면 큰 봉지를 많이 사용해야 함 : 그리디
		 * 큰 봉지 5kg의 무게가 작은 봉지 3kg의 무게의 수가 아니므로 무조건
		 * 
		 */
		
		for(int i = N/5; i >= 0; --i) {
			weight = N - (5*i);
			if(weight % 3 == 0) {
				ans = i + weight / 3;
				break;
			}
		}
		System.out.println(ans);
		
	}

}

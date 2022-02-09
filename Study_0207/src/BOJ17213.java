import java.util.Arrays;
import java.util.Scanner;
/*
 * 중복 조합 문제
 * 모든 과일 적어도 1개, 과일의 종류 수, 훔칠 수 있는 과일의 개수 -> 훔칠 수 있는 경우의 수
 * 내가 처음 생각한 것 : 과일의 종류 별로 몇 개 선택할지 -> 시간초과
 * 해법 : 10 - 3 = 7개를 어떤 과일로 선택할지 -> 중복 조합
 * 조합론 진짜 어렵다ㅠㅠ
 */
public class BOJ17213 {
	static int N, M, numbers[];
	static int totalCnt = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
//		numbers = new int[M - N];
		stealFruit2(0, 0);
		System.out.println(totalCnt);
	}
	public static void stealFruit(int cnt) {
		if(cnt == N - 1) {
			int sum = 0;
			if(sum <= M - N)
				totalCnt++;
			return;
		}
		for (int i = 0; i <= M - N; i++) {
//			numbers[cnt] = i;
			stealFruit(cnt+1);
		}
	}
	
	static void stealFruit2(int cnt, int start) {
		if(cnt == M - N) {
			totalCnt++;
			return;
		}
		
		for(int i = start; i < N; i++) {
//			numbers[cnt] = i + 1;
			stealFruit2(cnt + 1, i);
		}
	}
}

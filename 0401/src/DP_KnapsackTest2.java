import java.util.Scanner;

public class DP_KnapsackTest2 {
/*
4
10
5 10
4 40
6 30
3 50
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 물건의 개수
		int W = sc.nextInt();	// 가방의 무게
		int[] weights = new int[N+1];	// 물건의 무게
		int[] profits = new int[N+1];	// 물건의 가치
		
		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		
		int[][] D = new int[2][W+1];
		
		// 물건 0일 때 모든 무게를 만족하는 최적값 0 : D[0][0~W]
		// 무게 0에 대해 모든 물건의 최적값 0 : D[0~N][0]
		
		// 물건 1부터 가방의 모든 무게에 대해 최적값 저장
		int before = 0, current = 1;
		for (int i = 1; i <= N; i++) {
			for(int w = 1; w <= W; w++) {
				// 해당물건의 무게로 w 가방에 담을 수 있다면 (담는 경우, 담지 않는 경우 둘 중 최적값)
				if(weights[i] <= w) {
					D[current][w] = Math.max(D[before][w - weights[i]] + profits[i], D[before][w]);
				}
				// 없다면
				else {
					D[current][w] = D[before][w];
				}
//				System.out.print(D[i][w] + " ");
			}
			// XOR 다르면 1 같으면 0
			before ^= 1;
			current ^= 1;
//			System.out.println();
		}
		
		System.out.println(D[before][W]);
	}

}

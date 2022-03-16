import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12865_평범한_배낭2 {
/*
 * 메모리 12484
 * 시간 116
 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] dp = new int[K + 1];
		Point[] items = new Point[K]; // x : W, y : V

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			items[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = K; j >= items[i].x; j--) {	// K부터 현재 물건을 넣을 수 있는 무게까지 넣어보기
				dp[j] = Math.max(dp[j-items[i].x] + items[i].y, dp[j]); 
//				System.out.println(i + " " + Arrays.toString(dp));
			}
		}
		System.out.println(dp[K]);
	}

}

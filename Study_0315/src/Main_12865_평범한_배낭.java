import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865_평범한_배낭 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] dp = new int[N + 1][K + 1];
		Point[] items = new Point[N + 1]; // x : W, y : V

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			items[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		for (int i = 1; i <= N; i++) { 
	        for (int j = 1; j < items[i].x; j++) 
	            dp[i][j] = dp[i - 1][j]; 
	        for (int j = items[i].x; j <= K; j++)
	            dp[i][j] = Math.max(dp[i - 1][j - items[i].x] + items[i].y, dp[i - 1][j]); //배낭에 넣는 경우와 안 넣는 경우 중 최댓값 저장
	    }
		
		System.out.println(dp[N][K]);

	}

}

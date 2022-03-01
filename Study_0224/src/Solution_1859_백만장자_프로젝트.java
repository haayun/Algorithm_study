import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1859_백만장자_프로젝트 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input_money.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			
			int[] price = new int[N];
			long ans = 0;
			for(int i =0; i<N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			int sell = 0;
			for(int i = N - 1; i >= 0; i--) {
				sell = Math.max(sell, price[i]);
				ans += (sell - price[i] > 0 ? sell-price[i] : 0);
			}
			
			System.out.println("#" + tc + " " + ans);
		
		}

	}

}

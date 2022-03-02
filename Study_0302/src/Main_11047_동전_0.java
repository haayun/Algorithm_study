import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11047_동전_0 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] coins = new int[N];
		int max_index = 0;			// 사용가능한 동잔 중 가치가 가장 높은 동전 인덱스 
		
		// 입력 
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
			if(coins[i] <= K) max_index = Math.max(max_index, i);
		}
		
		// 연산 
		int cnt = 0;
		for(int i = max_index; i >= 0; i--) {
			cnt += K / coins[i];
			K %= coins[i];
		}
		
		// 출력 
		System.out.println(cnt);
	}

}

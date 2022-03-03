import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11399_ATM {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		int[] money = new int[N];
		for(int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(money);
		
		int ans = 0;
		int temp = 0;
		for(int i = 0; i < N; i++) {
			temp += money[i];
			ans += temp;
		}
		System.out.println(ans);
	}

}
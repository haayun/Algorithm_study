import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1052_물병 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		while (true) {
			String s = Integer.toBinaryString(N);
			int water = s.length();
			
			int temp = 0;
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '1') {
					temp++;
				}
			}
			if(temp <= K) break;
			
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '1') {
					ans += 1 << i;
					water += 1 << i;
					break;
				}
			}
		}
		System.out.println(ans);
	}

}

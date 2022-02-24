import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1107_리모컨 {

	static boolean[] buttons;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		buttons = new boolean[10];
		Arrays.fill(buttons, true); 
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) 
			buttons[Integer.parseInt(st.nextToken())] = false;
			
		int result = Math.abs(100 - N);
		int temp = 0;
		for(int i = 0; i < 1000000; i++) {
			if(check(i)) {
				result = Math.min(result, getLen(i) + Math.abs(i - N));
			}
		}
		
		System.out.println(result);
	}
	
	static int getLen(int i) {
		int cnt = 1;
		while(i >= 10) {
			i /= 10;
			cnt++;
		}
		return cnt;
	}
	
	static boolean check(int i) {
		if(i == 0 && !buttons[0])
			return false;
		while(i > 0) {
			if(!buttons[i % 10]) {
				return false;
			}
			i /= 10;
		}
		return true;
	}

}

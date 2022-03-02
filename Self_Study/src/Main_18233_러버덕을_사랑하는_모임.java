import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18233_러버덕을_사랑하는_모임 {

	static int N, P, E;
	static int[] input[], p, ans;
	static StringBuilder sb = new StringBuilder();
	static boolean flag = false;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		input = new int[N][];
		p = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			input[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		}

		
		combination(0, 0);
		
		if(sb.length() <= 0)
			System.out.println("-1");
		else
			System.out.println(sb);
	}

	public static void combination(int cnt, int start) {
		
		if(cnt == P) {
			
			ans = new int[N];
			if(!available()) return;
			
			for(int i = 0; i < N; i++) {
				sb.append(ans[i]).append(" ");;
			}
			sb.append("\n");
			return;
			
		}
		
		for(int i = start; i < N; i++) {
			p[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
	
	public static boolean available() {
		if(flag) return false;
		
		int min = 0, max = 0;
		for(int i = 0; i < P; i++) {
			min += input[p[i]][0];
			max += input[p[i]][1];
			
			ans[p[i]] += input[p[i]][0];
		}
		
		if(min > E || E > max) return false;
		
		flag = true;
		int temp_E = E - min;
		
		for(int i = 0; i < P; i++) {
			int diff = input[p[i]][1] - input[p[i]][0];
			if(temp_E <= diff) {
				ans[p[i]] += temp_E;
				temp_E = 0;
				
			} else {
				temp_E -= diff;
				ans[p[i]] += diff;
			}
		}
		return true;
	}
	
}

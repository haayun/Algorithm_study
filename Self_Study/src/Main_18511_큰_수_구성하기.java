

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_18511_큰_수_구성하기 {
	
	static int N, K, expo, answer;
	static int[] num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		num = new int[K];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		answer = num[K-1];
//		answer = 0;
		
		int tmp = N;
		expo = 1;
		while(tmp >= 10) {
			tmp /= 10;
			expo++;
		}
		makeNum(0, 0);
		System.out.println(answer);
		
	}
	
	static void makeNum(int res, int cnt) {
		if(res > N) return;
		answer = Math.max(res, answer);

		if(cnt == expo) {
			answer = res;
			return;
		}
		
		for(int i = 0; i < K; i++) {
			res *= 10;
			res += num[i];
			makeNum(res, cnt+1);
			res /= 10;
		}
	}

}

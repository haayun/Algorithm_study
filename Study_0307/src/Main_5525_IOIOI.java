import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5525_IOIOI {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] text = br.readLine().toCharArray();
		N = 1 + 2 * N;
		char[] pattern = new char[N];
		for(int i = 0; i < N; i++) {
			if(i % 2 == 0) {
				pattern[i] = 'I';
			} else {
				pattern[i] = 'O';
			}
		}
		
		int[] pi = new int[N];
		for(int i = 1, j = 0; i < N; i++) {
			while(j > 0 && pattern[i] != pattern[j]) j = pi[j-1];
			if(pattern[i] == pattern[j]) pi[i] = ++j;
			else pi[i] = 0;
		}
		
		int cnt = 0;
		
		for(int i = 0, j = 0; i < M; i++) {
			while(j > 0 && text[i] != pattern[j]) j = pi[j-1];
			
			if(text[i] == pattern[j]) {
				if(j == N-1) {
					cnt++;
					j = pi[j];
				} else {
					j++;
				}
			}
		}
		System.out.println(cnt);
	}

}

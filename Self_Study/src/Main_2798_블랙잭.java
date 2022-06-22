

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2798_블랙잭 {
	static int[] cards;
	static int N, M, answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cards = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		answer = 0;
		comb(0, 0, 0);
		System.out.println(answer);
	}
	
	static void comb(int cnt, int start, int chosen) {
		if(cnt == 3) {
			if((Math.abs(M - chosen) < Math.abs(M - answer)) && M >= chosen) {
				answer = chosen;
			}
			return;
		}
		
		for(int i = start; i < N; i++) {
			chosen += cards[i];
			comb(cnt+1, i+1, chosen);
			chosen -= cards[i];
		}
		
	}

}

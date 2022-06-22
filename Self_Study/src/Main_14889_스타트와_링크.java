

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14889_스타트와_링크 {
	static int N, answer, lCnt;
	static int[][] ability;
	static boolean[] team; // true : link, false : start

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		ability = new int[N][N];
		answer = Integer.MAX_VALUE;
		team = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				ability[i][j] = Integer.parseInt(st.nextToken());
		}

		lCnt = N/2;
		comb(0, 0);
		System.out.println(answer);

	}

	static void comb(int cnt, int start) {
		if (cnt == lCnt) {
			calc();
			return;
		}

		for (int i = start; i < N; i++) {
			team[i] = true;
			comb(cnt + 1, i + 1);
			team[i] = false;
		}

	}

	static void calc() {
		int lAb = 0, sAb = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (team[i] && team[j]) {
					lAb += ability[i][j];
				}
				if (!team[i] && !team[j]) {
					sAb += ability[i][j];
				}
			}
		}

		answer = Math.min(answer, Math.abs(lAb - sAb));
	}

}

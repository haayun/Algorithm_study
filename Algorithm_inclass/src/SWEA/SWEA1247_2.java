package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1247_2 {
	static class place {
		int x, y;

		place(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "[" + x + ", " + y + "]";
		}

	}

	static int N, ans;
	static boolean[] visited;
	static place[] places, path;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			ans = Integer.MAX_VALUE;
			place company, home;
			places = new place[N];
			path = new place[N];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N + 2; i++) {
				if (i == 0)  company = new place(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				if (i == 1) home = new place(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				else places[i - 2] = new place(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			

			System.out.println("#" + tc + " " + ans);
		}
	}

	static boolean np() {
		
		
		return true;
		
	}
}

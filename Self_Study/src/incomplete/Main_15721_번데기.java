package incomplete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15721_번데기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		int call = Integer.parseInt(br.readLine());
		int cnt = 0, cur = 0, round = 1;
		outer : while (true) {
			int[] res = rule(round++);
			for(int i = 0; i < res.length; i++) {
				if(res[i] == call) cnt++;
				if(cnt == T) break outer;
				cur++;
				if(cur == A) cur = 0;
			}
		}
		System.out.println(cur);
	}

	static int[] rule(int round) {
		round += 1;
		int[] res = new int[round * 2 + 4];
		res[1] = res[3] = 1;
		
		for (int i = 4 + round; i < res.length; i++) {
			res[i] = 1;
		}
		return res;
	}

}

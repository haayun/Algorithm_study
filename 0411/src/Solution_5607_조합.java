import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_조합 {

	static final int MOD = 1234567891;
	static final int MAX = 1000000;
	static long[] factorial;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		factorial = new long[MAX + 1];
		factorial[0] = 1;
		for(int i = 1; i <= MAX; i++)
			factorial[i] = (factorial[i-1] * i ) % MOD;
		
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			long top = factorial[N] % MOD;
			long bottom = ((factorial[N - R] % MOD) * (factorial[R] % MOD)) % MOD;
			
			long answer = (top * fermat(bottom, MOD - 2)) % MOD;
			
			System.out.println("#" + tc + " " + answer);
		}
	}

	static long fermat(long a, int p) {
		if (p == 0) return 1;
		long half = fermat(a, p / 2);

		if (p % 2 == 0) return ((half % MOD) * (half % MOD)) % MOD;
		else return (((half * a) % MOD) * (half % MOD)) % MOD;

	}

}

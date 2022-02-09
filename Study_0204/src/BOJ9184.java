import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9184 {
/*
 * dp인 걸 알면 풀 만한 문제였다
 * 비슷하거나 같은 연산을 너무 반복적으로 함 -> 그 결과를 배열에 저장해 놓는 dp 풀이법
 * 이미 dp배열에 있는 값이라면 바로 리턴하는 것이 핵심!
 */
	static int[][][] dp = new int[51][51][51];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			int result = 0;
			if (a == -1 && b == -1 && c == -1)
				break;
			if (a <= 0 || b <= 0 || c <= 0)
				result = 1;
			else
				result = w(a, b, c);
			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(result)
					.append('\n');
		}
		System.out.println(sb.toString());
	}

	static int w(int a, int b, int c) {
		if (dp[a][b][c] != 0)
			return dp[a][b][c];
		
		if (a <= 0 || b <= 0 || c <= 0)
			dp[a][b][c] = 1;
		
		else if (a > 20 || b > 20 || c > 20)
			dp[a][b][c] = w(20, 20, 20);
		
		else if (a < b && b < c)
			dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		
		else
			dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);

		return dp[a][b][c];
	}
}

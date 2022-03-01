import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2805_농작물_수확하기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] farm;
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			farm = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] temp = br.readLine().toCharArray();
				for (int j = 0; j < N; j++)
					farm[i][j] = temp[j] - '0';
			}

			int ans = 0;

			for (int i = 0; i <= N / 2; i++) {
				for (int j = N / 2 - i; j <= N / 2 + i; j++) {
					ans += farm[i][j];
				}
			}

			for(int i = N / 2 + 1; i < N; i++) {
				for(int j = N / 2 - (N - 1 - i); j <= N / 2 + (N - 1 - i); j++) {
					ans += farm[i][j];
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}

	}

}

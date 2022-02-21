import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1080_행렬 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

		int[][] A = new int[N][M], B = new int[N][M];
		int ans = 0;

		for (int i = 0; i < 2 * N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (i < N)
					A[i][j] = temp[j] - '0';
				else
					B[i - N][j] = temp[j] - '0';
			}
		}

		for (int i = 0; i <= N - 3; i++) {
			for (int j = 0; j <= M - 3; j++) {
				if (A[i][j] == B[i][j]) continue;
				ans++;
				for (int r = 0; r < 3; r++) 
					for (int c = 0; c < 3; c++) 
						A[i + r][j + c] = (A[i + r][j + c] + 1) % 2;
				
			}
		}

		boolean flag = true;

		outer: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] != B[i][j]) {
					flag = false;
					break outer;
				}
			}
		}

		if (!flag)
			ans = -1;
		System.out.println(ans);
	}

}

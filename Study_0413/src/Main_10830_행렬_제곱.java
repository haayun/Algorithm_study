import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10830_행렬_제곱 {

	static int N;
	static int[][] matrix;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		matrix = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] answer = divide(B);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				sb.append(answer[i][j] % 1000).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	static int[][] divide(long k) {
		if(k == 1)
			return matrix;
		if(k % 2 == 0) {
			int[][] sub = divide(k / 2);
	        return combine(sub, sub);
		}
		return combine(matrix, divide(k - 1));
	}
	
	static int[][] combine(int[][] m1, int[][] m2){
		int[][] res = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					res[i][j] += (m1[i][k] * m2[k][j]);
				}
				res[i][j] %= 1000;
			}
		}
		return res;
	}
	

}

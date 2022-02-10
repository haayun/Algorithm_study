import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1451 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[][] rect = new int[N][M], sum = new int[N][M];
		char[] temp;
		// 직사각형 배열 입력
		for(int i = 0; i < N; i++) {
			temp = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				rect[i][j] = Character.digit(temp[j], 10);
			}
		}
		
		// 누적합
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sum[i][j] = rect[i][j];
				
				for(int a = 0; a < j; a++) {
					sum[i][j] += rect[i][a];
				}
				if(i > 0)
					sum[i][j] += sum[i-1][j];
			}
		}
		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++)
//				System.out.print(sum[i][j] + " ");
//			System.out.println();
//		}
		
	}
}

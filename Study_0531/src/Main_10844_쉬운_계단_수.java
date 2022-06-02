import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10844_쉬운_계단_수 {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		N = Integer.parseInt(br.readLine());
		int[][] stair = new int[N][10];
		for(int i = 1; i <= 9; i++) {
			stair[0][i] = 1;
		}
		// 저장
		for(int i = 1; i < N; i++) {
			for(int j = 0; j <= 9; j++) {
				if(j - 1 >= 0) stair[i][j] += stair[i-1][j-1];
				if(j + 1 <= 9) stair[i][j] += stair[i-1][j+1];
				stair[i][j] %= 1000000000;
			}
		}
		// 마지막 줄 합치기
		int res = 0;
		for(int i = 0; i <= 9; i++) {
			res += stair[N-1][i];
			res %= 1000000000;
		}
		
		// 출력
		System.out.println(res);
	}

}

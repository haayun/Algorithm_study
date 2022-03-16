import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2448_별_찍기_11_2 {
	
	// 시간 초과
	
	static char[][] star;
	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		star = new char[N][N * 2 - 1];
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(star[i], ' ');
		}
		
		printStar(0, 0, N);
		
		for(int i = 0; i < N; i++) {
			for(int j= 0; j < 2 * N - 1; j++)
				System.out.print(star[i][j]);
			System.out.println();
		}

	}

	static void printStar(int row, int col, int size) {
		
		if(size == 3) {
			star[row][col+2] = '*';
			for(int j = 1; j < 2 * size -1; j+=2) 
				star[row+1][col+j] = '*';
			for(int j = 0; j < 2 * size -1; j++) 
				star[row+2][col+j] = '*';
			return;
		}
		int next_size = size / 2;
		printStar(row, col + next_size, next_size);
		printStar(row + next_size, col, next_size);
		printStar(row + next_size, col + size, next_size);
	}

}

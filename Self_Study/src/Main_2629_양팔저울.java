
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2629_양팔저울 {
	// 냅색 문제 (dp)
	
	public static void main(String[] args) throws IOException {
		int MAX = 15000;	// 확인가능한 가장 큰 수 : 500g * 30개 = 15000g
		boolean[][] check = new boolean[31][15000 + 1];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 추의 개수 입력
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		// 현재 추로 추가된 확인 가능한 무게
		int w = Integer.parseInt(st.nextToken());
		check[0][w] = true;
		for(int i = 1; i < N; i++) {
			// 추의 무게 입력
			w = Integer.parseInt(st.nextToken());
			check[i][w] = true;
			for(int j = 1; j <= MAX; j++) {
				if(!check[i-1][j]) continue;
				check[i][j] = true;
				// 이전까지 확인 가능했던 모든 무게에 현재 추를 더하거나 빼보기
				if(j > w) check[i][j-w] = true;
				if(j < w) check[i][w-j] = true;
				if(w + j <= MAX) check[i][w+j] = true;
			}
			
		}
		// 구슬 개수 입력
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			// 구슬의 무게 입력
			int ball = Integer.parseInt(st.nextToken());
			// 확인 가능한 가장 큰 수보다 크거나 주어진 추로 확인 불가하다면
			if(ball > MAX || !check[N-1][ball])  System.out.print("N ");
			// 그 외는 모두 확인 가능
			else System.out.print("Y ");
		}
	}

}

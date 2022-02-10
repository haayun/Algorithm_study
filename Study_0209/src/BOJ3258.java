import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3258 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 입력
		int N = Integer.parseInt(st.nextToken()), Z = Integer.parseInt(st.nextToken()) % N,
				M = Integer.parseInt(st.nextToken());
		
		// 장애물이면 true
		boolean[] field = new boolean[N];
		int ans = 1;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) 
			field[Integer.parseInt(st.nextToken()) % N] = true;
		
		// N까지 돌리면서 검사
		for (; ans <= N; ans++) {
			int curr = 1;
			boolean[] temp = new boolean[N];
			temp = Arrays.copyOf(field, N);
			while (true) {
				if (!temp[(curr + ans) % N]) {
					curr = (curr + ans) % N;
					temp[curr] = true;
					if (Z == curr) {	// 도착점에 도착하면 바로 출력
						System.out.println(ans);
						return;
					}
				} else {
					break;
				}
			}
		}
	}

}

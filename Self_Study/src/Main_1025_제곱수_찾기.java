
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1025_제곱수_찾기 {
	// 브루트포스 ㅠㅠ 어렵다...
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] nums = new int[N][M];
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++)
				nums[i][j] = s.charAt(j) - '0';
		}
		
		int answer = -1;
		for(int r = 0; r < N; r++) {	// 모든 자리의 수에서 시작하는
			for(int c = 0; c < M; c++) {
				for(int dr = -N + 1; dr < N; dr++) {	// 가능한 모든 등차에 대해서 (음수 포함)
					for(int dc = -M + 1; dc < M; dc++) {
						if(dr == 0 && dc == 0) continue;
						int nr = r, nc = c;
						String s = "";
						while(nr >= 0 && nr < N && nc >= 0 && nc < M) {
							s += nums[nr][nc];
							answer = Math.max(answer, isSquare(Integer.parseInt(s)));
							nr += dr;
							nc += dc;
						}
					}
				}
			}
		}
		
		// 예외 케이스 발생...
		if(N == 1 && M == 1) answer = isSquare(nums[0][0]);
		System.out.println(answer);
		
	}
	
	static int isSquare(int num) {
		int sqrt = (int) Math.sqrt(num);
		if(sqrt * sqrt == num) return num;
		return -1;
	}

}

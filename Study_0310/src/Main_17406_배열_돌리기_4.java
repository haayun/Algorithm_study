import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17406_배열_돌리기_4 {

	static int[][] arr, rot, save;
	// 우 하 좌 상 (시계방향 회전)
	static int[][] d = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int N, M, K, ans;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];		// 입력받는 배열
		save = new int[N][M];		// 저장하는 배열
		rot = new int[K][4];		// 회전 연산 정보 배열 
		ans = Integer.MAX_VALUE;
		
		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				save[i][j] = arr[i][j];
			}
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			rot[i] = new int[] { i, r, c, s };	// 배열 인덱스, 위치(r, c), 회전 횟수 
		}
		
		// 순열 (배열 인덱스를 기준으로 함)
		do {
			for(int i = 0; i < K; i++) {
				for(int j = 1; j <= rot[i][3]; j++) {
					rotate(rot[i][1] - j, rot[i][2] - j, rot[i][1] + j, rot[i][2] + j);
				}
			}
			// 최솟값 갱신 
			ans = Math.min(ans, arrVal());
			// 초기 배열로 돌려놓기 
			deepCopy();
		} while(np());
		
		// 출력
		System.out.println(ans);
	}
	
	// 2차원 배열 깊은 복사 
	static void deepCopy(){
		for (int i = 0; i < N; i++) {
	        System.arraycopy(save[i], 0, arr[i], 0, M);
	    }
	}
	
	// 배열의 값 반환 
	static int arrVal() {
		int min = Integer.MAX_VALUE, sum;
		for (int[] a : arr) {
			sum = 0;
			for (int i : a) {
				sum += i;
			}
			min = Math.min(sum, min);
		}
		return min;
	}
	
	// 회전 연산
	static void rotate(int sr, int sc, int er, int ec) {
		int save = arr[sr][sc], temp;
		int r = sr, c = sc + 1, dir = 0;
		do {
			temp = arr[r][c];
			arr[r][c] = save;
			save = temp;

			r += d[dir][0];
			c += d[dir][1];
			if (r < sr || r > er || c < sc || c > ec) {
				r = r - d[dir][0] + d[(dir + 1) % 4][0];
				c = c - d[dir][1] + d[(dir + 1) % 4][1];
				dir = (dir + 1) % 4;
			}
		} while (r != sr|| c != sc + 1 );
	}
	
	// next perm
	static boolean np() {
		int i = K - 1;
		while (i > 0 && rot[i - 1][0] >= rot[i][0])
			--i;

		if (i == 0)
			return false;

		int j = K - 1;
		while (rot[i - 1][0] >= rot[j][0])
			--j;

		swap(i - 1, j);

		int k = K - 1;
		while (i < k) {
			swap(i++, k--);
		}

		return true;
	}
	static void swap(int i, int j) {
		int[] temp = rot[i].clone();
		rot[i] = rot[j].clone();
		rot[j] = temp;
	}
	
}

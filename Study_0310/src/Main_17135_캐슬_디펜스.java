import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17135_캐슬_디펜스 {

	static int[][] map, save;
	static int[] p;
	static int N, M, D, ans, cnt;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		save = new int[N][M];
		p = new int[M];
		ans = 0;
		int temp = 0;
		while (++temp <= 3)
			p[M - temp] = 1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				save[i][j] = map[i][j];
			}
		}

		do {
			int cnt = 0;
			
			for(int i = 0; i < N; i++) {
				if(gameOver()) break;
				
				for (int j = 0; j < M; j++) {
					if (p[j] != 1) continue;
				}
				
				System.out.println(i);
				for (int[] is : map) {
					for (int a : is) {
						System.out.print(a + " ");
					}
					System.out.println();
				}
				System.out.println(cnt + "\n");
				
				move();
				
			}
			
			ans = Math.max(ans, cnt);
			deepCopy();
		} while (np());

		System.out.println(ans);
	}

	// 공격하기
	static void attack(int c) {
		// 가장 가까운, 가장 왼쪽의 적

	}

	// 적 이동
	static void move() {
		for (int i = N - 2; i >= 0; i--) {
			System.arraycopy(map[i], 0, map[i + 1], 0, M);
		}
		
		
	}

	// 게임 종료 조건
	static boolean gameOver() {

		int sum = 0;
		for (int[] is : map) {
			for (int i : is) {
				sum += i;
			}
		}
		
		
		return sum == 0 ? true : false;
	}

	// 2차원 배열 깊은 복사
	static void deepCopy() {
		for (int i = 0; i < N; i++) {
			System.arraycopy(save[i], 0, map[i], 0, M);
		}
	}

	// next perm
	static boolean np() {
		int i = M - 1;
		while (i > 0 && p[i - 1] >= p[i])
			--i;

		if (i == 0)
			return false;

		int j = M - 1;
		while (p[i - 1] >= p[j])
			--j;

		swap(i - 1, j);

		int k = M - 1;
		while (i < k) {
			swap(i++, k--);
		}

		return true;
	}

	static void swap(int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ3190 {
	// 우하좌상
	static int[][] d = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N + 1][N + 1]; // 기본 0, 뱀 1, 사과 2
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			// 사과 위치 입력
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 2;
		}
		int L = Integer.parseInt(br.readLine());
		Map<Integer, Character> command = new HashMap<>();
		for (int i = 0; i < L; i++) {
			// 뱀 방향 변환 정보 입력
			st = new StringTokenizer(br.readLine(), " ");
			command.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
		}
		// Deque : 머리 -> First, 꼬리 -> Last 
		Deque<int[]> snake = new LinkedList<>();
		int dir = 0, time = 0;
		snake.addFirst((new int[] { 1, 1 }));
		while (true) {
			time++;
			// 다음 위치 (머리)
			int nr = snake.peekFirst()[0] + d[dir][0];
			int nc = snake.peekFirst()[1] + d[dir][1];

			// 경계 체크
			if (nr <= 0 || nr > N || nc <= 0 || nc > N || map[nr][nc] == 1)
				break;

			// 몸길이를 줄이고 꼬리칸 비워주기
			if (map[nr][nc] != 2) {
				map[snake.peekLast()[0]][snake.peekLast()[1]] = 0;
				snake.pollLast();
			}
			// 머리 전진, 해당 위치 1로
			snake.offerFirst(new int[] { nr, nc });
			map[nr][nc] = 1;

			if (command.containsKey(time)) {
				switch (command.get(time)) {
				// 왼쪽으로 90도
				case 'L':
					dir = (dir + 3) % 4;
					break;
				// 오른쪽으로 90도
				case 'D':
					dir = (dir + 1) % 4;
					break;
				}
			}
//			System.out.println(snake.peekFirst()[0] + " " + snake.peekFirst()[1]);
		}
		System.out.println(time);
	}

}

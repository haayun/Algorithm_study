import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 입력 
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int size = 100000, ans = 0;
		
		// 방문 체크 겸 시간 저장  
		int[] time = new int[size + 1];
		int[] moves;
		time[N] = 1;

		// bfs
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(N);
		while (!queue.isEmpty()) {
			if (queue.peek() == K) {
				ans = time[K] - 1;
				break;
			}

			int current = queue.poll();
			moves = new int[] { current -1, current + 1, current * 2 };

			for (int i = 0; i < 3; i++) {
				int next = moves[i];
				if (next >= 0 && next <= size && time[next] == 0) {
					time[next] = time[current] + 1;
					queue.offer(next);
				}
			}
		}
		// 출력
		System.out.println(ans);
	}

}

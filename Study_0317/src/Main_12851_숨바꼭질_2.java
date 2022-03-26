import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12851_숨바꼭질_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 입력
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int MAX = 100000;
		int[] visited = new int[MAX + 1];

		// x : 위치, y : 시간
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(N, 0));
		visited[N] = 1;

		int time = Integer.MAX_VALUE, cnt = 0; // 최단 시간, 경로 가짓수

		// bfs 연산
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			if (cur.x == K) {
				time = Integer.min(time, cur.y); // 최단 시간
				if (time == cur.y)
					cnt++; // 시간이 같다면 카운팅

				continue;
			}

			int[] next = { cur.x - 1, cur.x + 1, cur.x * 2 };

			for (int i = 0; i < 3; i++) {
				int n = next[i];
				if (n < 0 || n > MAX) continue; // 경계체크

				// 아직 방문을 안했거나 또다른 최단 경로라면 큐에 삽입
				if (visited[n] == 0 || visited[n] == cur.y + 1) {
					visited[n] = cur.y + 1;
					queue.offer(new Point(n, cur.y + 1));
				}
			}

		}
		
		// 출력
		System.out.println(time + "\n" + cnt);
		
	}

}

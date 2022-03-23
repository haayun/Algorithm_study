import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205_맥주_마시면서_걸어가기 {
/*
 * 메모리 12548
 * 시간 104
 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		Point[] places;
		boolean[] visited;
		int beer = 20;

		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine()) + 2;
			places = new Point[N];
			visited = new boolean[N];
			
			// 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				places[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			// 연산 (bfs)
			Queue<Point> queue = new LinkedList<>();
			visited[0] = true;
			queue.offer(new Point(places[0].x, places[0].y));
			
			while(!queue.isEmpty()) {
				Point cur = queue.poll();
				for(int i = 0; i < N; i++) {
					if(visited[i]) continue;
					int tmp = Math.abs(places[i].x - cur.x) + Math.abs(places[i].y - cur.y);
					tmp = tmp % 50 > 0 ? tmp / 50 + 1 : tmp / 50;
					if(tmp > beer) continue;
					
					visited[i] = true;
					queue.offer(places[i]);					
				}
			}
			
			// 출력
			if(visited[N-1]) System.out.println("happy");
			else	System.out.println("sad");
		}
	}

}

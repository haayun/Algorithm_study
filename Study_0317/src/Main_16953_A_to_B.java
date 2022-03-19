import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16953_A_to_B {
	/*
	 * bfs
	 * 메모리 15252
	 * 시간 108
	 */
	
	static class Point {
		long num;
		int cnt;
		
		Point(long num, int cnt){
			this.num = num;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());

		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(A, 1));
		
		int ans = -1;
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			if(cur.num == B) {
				ans = cur.cnt;
				break;
			}
			
			long case1 = cur.num * 2;
			if(case1 <= B) {
				queue.offer(new Point(case1, cur.cnt+1));
			}
			
			long case2 = cur.num * 10 + 1;
			if(case2 <= B) {
				queue.offer(new Point(case2, cur.cnt+1));
			}
		}
		
		System.out.println(ans);
		
	}

}

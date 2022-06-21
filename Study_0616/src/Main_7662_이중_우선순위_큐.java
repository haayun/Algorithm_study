import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main_7662_이중_우선순위_큐2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			PriorityQueue<Point> minPQ = new PriorityQueue<>((s1, s2) -> s1.x - s2.x);
			PriorityQueue<Point> maxPQ = new PriorityQueue<>((s1, s2) -> s2.x - s1.x);
			ArrayList<Boolean> check = new ArrayList<>();

			int k = Integer.parseInt(br.readLine());
			int idx = 0;
			
			for (int i = 0; i < k; i++) {
				String[] cmd = br.readLine().split(" ");
				if (cmd[0].equals("I")) {
					int num = Integer.parseInt(cmd[1]);
					minPQ.add(new Point(num, idx));
					maxPQ.add(new Point(num, idx++));
					check.add(true);

				} else {
					if (cmd[1].equals("1")) {
						pollPQ(maxPQ, check);
						if(!maxPQ.isEmpty()) {						
							check.set(maxPQ.peek().y, false);
							maxPQ.poll();
						}

					} else {
						pollPQ(minPQ, check);
						if(!minPQ.isEmpty()) {						
							check.set(minPQ.peek().y, false);
							minPQ.poll();
						}
					}
				}
			}
			pollPQ(maxPQ, check);
			pollPQ(minPQ, check);
			if(maxPQ.isEmpty())
				System.out.println("EMPTY");
			else
				System.out.println(maxPQ.poll().x + " " + minPQ.poll().x);
		}
	}

	static void pollPQ(PriorityQueue<Point> pq, ArrayList<Boolean> check) {
		while (!pq.isEmpty() && !check.get(pq.peek().y)) {
			pq.poll();
		}
	}
}

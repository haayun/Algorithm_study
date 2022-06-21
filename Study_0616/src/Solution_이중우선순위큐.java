import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_이중우선순위큐 {

	public static void main(String[] args) {
		int[] res = solution(new String[] { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" });
		System.out.println(Arrays.toString(res));
		res = solution(new String[] { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" });
		System.out.println(Arrays.toString(res));
	}

	public static int[] solution(String[] operations) {
		int[] answer = new int[2];
		PriorityQueue<Point> minPQ = new PriorityQueue<>((s1, s2) -> s1.x - s2.x);
		PriorityQueue<Point> maxPQ = new PriorityQueue<>((s1, s2) -> s2.x - s1.x);
		ArrayList<Boolean> check = new ArrayList<>();

		int idx = 0;
		
		for (int i = 0; i < operations.length; i++) {
			String[] cmd = operations[i].split(" ");
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
						System.out.println(maxPQ.poll());
					}

				} else {
					pollPQ(minPQ, check);
					if(!minPQ.isEmpty()) {						
						check.set(minPQ.peek().y, false);
						System.out.println(minPQ.poll());
					}
				}
			}
			System.out.println(check.toString());
		}

		pollPQ(maxPQ, check);
		pollPQ(minPQ, check);

		if (!maxPQ.isEmpty())
			answer[0] = maxPQ.poll().x;
		if (!minPQ.isEmpty())
			answer[1] = minPQ.poll().x;
		return answer;
	}

	static void pollPQ(PriorityQueue<Point> pq, ArrayList<Boolean> check) {
		while (!pq.isEmpty() && !check.get(pq.peek().y)) {
			System.out.println(pq.poll());
		}
	}
}

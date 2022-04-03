import java.awt.Point;
import java.util.HashMap;

public class Solution_키패드_누르기 {
// https://programmers.co.kr/learn/courses/30/lessons/67256
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 }, "right"));
		System.out.println(solution(new int[] { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 }, "left"));
		System.out.println(solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }, "right"));
	}

	static HashMap<Integer, Point> map = new HashMap<>();

	static void init() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				map.put(i * 3 + j + 1, new Point(i, j));
			}
		}
		map.put(0, new Point(3, 1));

	}

	static String solution(int[] numbers, String hand) {
		StringBuilder sb = new StringBuilder();
		init();

		Point left = new Point(3, 0);
		Point right = new Point(3, 2);
		// 왼손이면 true, 오른손이면 false;
		boolean easyHand = hand.equals("left") ? true : false;
		boolean flag = easyHand;
		for (int i = 0; i < numbers.length; i++) {
			Point target = map.get(numbers[i]);

			if (target.y == 1) {
				int lDist = Math.abs(target.x - left.x) + Math.abs(target.y - left.y);
				int rDist = Math.abs(target.x - right.x) + Math.abs(target.y - right.y);
				if (lDist < rDist) {
					flag = true;
				} else if (lDist > rDist) {
					flag = false;
				} else {
					flag = easyHand;
				}
			}

			if (target.y == 0 || (target.y == 1 && flag)) { // 무조건 왼손
				sb.append("L");
				left = target;
			} else if (target.y == 2 || (target.y == 1 && !flag)) { // 무조건 오른
				sb.append("R");
				right = target;
			}
		}

		return sb.toString();
	}
}

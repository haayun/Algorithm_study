import java.util.Arrays;

public class Solution_로또의_최고_순위와_최저_순위 {

	public static void main(String[] args) {
		int[] result = solution(new int[] { 0, 0, 0, 0, 0, 0 }, new int[] { 38, 19, 20, 40, 15, 25 });
		System.out.println(Arrays.toString(result));
	}

	public static int[] solution(int[] lottos, int[] win_nums) {
		int same = 0;
		int zero = 0;
		for (int lotto : lottos) {
			if (lotto == 0) {
				zero++;
				continue;
			}
			for (int win_num : win_nums) {
				if (win_num == lotto) {
					same++;
					break;
				}
			}
		}
		return new int[] { 7 - Math.max(same + zero, 1), 7 - Math.max(same, 1) };
	}

}

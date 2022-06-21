import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_메뉴_리뉴얼2 {

	public static void main(String[] args) {
//		String[] answer = solution(new String[] { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" },
//				new int[] { 2, 3, 4 });
//		System.out.println(Arrays.toString(answer));
//		String[] answer = solution(new String[] { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" }, new int[] { 2, 3, 5 });
//		System.out.println(Arrays.toString(answer));
		String[] answer = solution(new String[] { "XYZ", "XWY", "WXA" }, new int[] { 2, 3, 4 });
		System.out.println(Arrays.toString(answer));
	}

	static HashMap<String, Integer>[] menu_comb;
	static boolean[] selected = new boolean[10];

	public static String[] solution(String[] orders, int[] course) {
		List<String> answer = new ArrayList<>();
		menu_comb = new HashMap[21];

		for (int i = 0; i < menu_comb.length; i++)
			menu_comb[i] = new HashMap<>();

		for (int i = 0; i < orders.length; i++) {
			char[] order = orders[i].toCharArray();
			Arrays.sort(order);
			comb(order, 0);
		}

		for (int i : course) {
			Map<String, Integer> map = menu_comb[i];
			int max = -1;

			List<String> tmp = new ArrayList<>();
			for (String key : map.keySet()) {
				int val = map.get(key);
				if (val == 1)
					continue;

				if (max < val) {
					tmp = new ArrayList<>();
					max = val;
					tmp.add(key);
				} else if (max == val) {
					tmp.add(key);
				}
			}

			for (String string : tmp) {
				answer.add(string);
			}

		}
		Collections.sort(answer);
		return answer.toArray(new String[answer.size()]);
	}

	static void comb(char[] order, int cnt) {

		if (cnt == order.length) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < order.length; i++) {
				if (selected[i])
					sb.append(order[i]);
			}
			int val = menu_comb[sb.length()].getOrDefault(sb.toString(), 0) + 1;
			menu_comb[sb.length()].put(sb.toString(), val);
			return;
		}

		selected[cnt] = true;
		comb(order, cnt + 1);
		selected[cnt] = false;
		comb(order, cnt + 1);
	}
}

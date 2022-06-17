import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution_메뉴_리뉴얼 {

	public static void main(String[] args) {
		String[] answer = solution(new String[] { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" },
				new int[] { 2, 3, 4 });
		System.out.println(Arrays.toString(answer));
//		answer = solution(new String[] { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" }, new int[] { 2, 3, 5 });
//		System.out.println(Arrays.toString(answer));
//		answer = solution(new String[] { "XYZ", "XWY", "WXA" }, new int[] { 2, 3, 4 });
		System.out.println(Arrays.toString(answer));
	}

	static String ord;
	static int[] crs;
//	static char[] menu = new char[27];
	static StringBuilder sb;
	static HashMap<String, Integer>[] menu_comb;

	public static String[] solution(String[] orders, int[] course) {
//		String[] answer = {};
		List<String> answer = new ArrayList<>();
		crs = course;
		menu_comb = new HashMap[orders.length];
		for (int i = 0; i < orders.length; i++)
			menu_comb[i] = new HashMap<>();

		for (int i = 0; i < orders.length; i++) {
			ord = orders[i];
			sb = new StringBuilder();
			comb(0, 0);
		}
		
		List<Map.Entry<String, Integer>> entryList;
		
		for (int i = 0; i < orders.length; i++) {
			Map<String, Integer> map = menu_comb[i];
			entryList = new LinkedList<>(map.entrySet());
			entryList.sort(((o1, o2) -> map.get(o2.getKey()) - map.get(o1.getKey())));
			for(Map.Entry<String, Integer> entry : entryList){
			    System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
			}
			System.out.println(entryList.get(Integer.valueOf(0)));
//			for(Map.Entry<String, Integer> entry : entryList) {
//				if(entry.getValue() != val) break;
//				answer.add(entry.getKey());
//			}
//			for (String key : menu_comb[i].keySet()) {
//				int val = menu_comb[i].get(key);
//				System.out.println(key + " : " + val);
//			}
		}

		return answer.toArray(new String[0]);
	}

	static void comb(int cnt, int start) {
		for (int i = 0; i < crs.length; i++) {
			if (cnt == crs[i]) {
//				System.out.println(sb);
				String s = sb.toString();
				menu_comb[cnt].putIfAbsent(s, 0);
				menu_comb[cnt].replace(s, menu_comb[cnt].get(s) + 1);
//				System.out.println(s + " : " + menu_comb[cnt].get(s));
			}
		}
		if (cnt == crs[crs.length - 1])
			return;

		for (int i = start; i < ord.length(); i++) {
			sb.append(ord.charAt(i));
			comb(cnt + 1, i + 1);
			sb.setLength(sb.length() - 1);
		}
	}
}

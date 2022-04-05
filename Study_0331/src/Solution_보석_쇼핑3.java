import java.util.Arrays;
import java.util.HashMap;

public class Solution_보석_쇼핑3 {
// https://programmers.co.kr/learn/courses/30/lessons/67258
	public static void main(String[] args) {
//		int[] ans = solution(new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
		int[] ans = solution(new String[] { "A", "B", "B", "B", "B", "B", "B", "C", "B", "A" });
		System.out.println(Arrays.toString(ans));
	}

	public static int[] solution(String[] gems) {
		int[] answer = { 1, gems.length };
		// 투 포인터 활용
		int left = 0, right = 0;

		HashMap<String, Integer> map = new HashMap<>();

		int index = 0; // 보석 종류 개수가 됨
		for (int i = 0; i < gems.length; i++) {
			if (map.containsKey(gems[i]))
				continue;
			map.put(gems[i], index++);
		}
		map.clear();
		
		int kind = 0; // 현재 몇 종류의 보석을 가지고 있는지
		map.put(gems[left], 1);
		while (left <= right && right < gems.length) {
			if (map.size() == index) {
				if (answer[1] - answer[0] > right - left) {
					answer = new int[] { left + 1, right + 1 };
				}
				left++;
				map.replace(gems[left-1], map.get(gems[left-1])-1);
				if (map.get(gems[left - 1]) == 0) {
					map.remove(gems[left-1]);
				}
			} else {
				right++;
				if (right == gems.length)
					break;
				if(map.containsKey(gems[right]))
					map.replace(gems[right], map.get(gems[right])+1);
				else
					map.put(gems[right], 1);
			}

		}

		return answer;
	}
}

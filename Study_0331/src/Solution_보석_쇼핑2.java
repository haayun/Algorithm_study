import java.util.Arrays;
import java.util.HashMap;

public class Solution_보석_쇼핑2 {
// https://programmers.co.kr/learn/courses/30/lessons/67258
	public static void main(String[] args) {
//		int[] ans = solution(new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
		int[] ans = solution(new String[] { "A", "B", "B", "B", "B", "B", "B", "C", "B", "A" });
		System.out.println(Arrays.toString(ans));
	}

	public static int[] solution(String[] gems) {
		int[] answer = { 0, gems.length - 1 };
		// 투 포인터 활용
		int left = 0, right = 0;

		int[] cnt;
		HashMap<String, Integer> map = new HashMap<>(); // 보석 스트링에 cnt 인덱스 매칭
		
		int total = 0; // 보석 종류 개수가 됨
		for (int i = 0; i < gems.length; i++) {
			if (map.containsKey(gems[i]))
				continue;
			map.put(gems[i], total++);
		}
		
		// 구간의 각 보석 수 카운트하는 배열
		cnt = new int[total];

		// 초기 설정
		int kind = 1; // 현재 몇 종류의 보석을 가지고 있는지
		cnt[map.get(gems[left])]++;
		
		while (left <= right && right < gems.length) {
			if (kind == total) {
				if (answer[1] - answer[0] > right - left) {	// 구간 길이 최소가 되도록 갱신
					answer = new int[] { left, right };
				}
				left++;
				cnt[map.get(gems[left - 1])]--;
				if (cnt[map.get(gems[left - 1])] == 0) {
					kind--;
				}
			} else {
				right++;
				if (right == gems.length)
					break;
				if (cnt[map.get(gems[right])] == 0)
					kind++;
				cnt[map.get(gems[right])]++;
			}
		}

		return answer;
	}
}

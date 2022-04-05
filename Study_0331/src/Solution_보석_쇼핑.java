import java.util.Arrays;
import java.util.HashMap;

public class Solution_보석_쇼핑 {
// https://programmers.co.kr/learn/courses/30/lessons/67258
	public static void main(String[] args) {
//		int[] ans = solution(new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
		int[] ans = solution(new String[] {"A","B","B","B","B","B","B","C","B","A"});
		System.out.println(Arrays.toString(ans));
	}

	public static int[] solution(String[] gems) {
		// 투 포인터 활용
		int left = 0, right = 0;
		
		// 구간의 각 보석 수 카운트하는 배열 
		int[] cnt = new int[gems.length];
		
		HashMap<String, Integer> map = new HashMap<>();	// 보석 스트링에 cnt 인덱스 매칭
		
		int index = 0;	// 보석 종류 개수가 됨
		for(int i = 0; i < gems.length; i++) {
			if(map.containsKey(gems[i])) continue;
			map.put(gems[i], index++);
		}
		
		int contain_gem = 0;	// 현재 몇 종류의 보석을 가지고 있는지 
		
		// right 포인터 이동
		while(true) {
			if(contain_gem == index)  break;
			
			if(cnt[map.get(gems[right])] == 0) contain_gem++;
			cnt[map.get(gems[right])]++;
			
			right++;
		}
		
		// left 포인터 이동
		while(true) {
			if(contain_gem < index)  break;
			
			cnt[map.get(gems[left])]--;
			if(cnt[map.get(gems[left])] == 0) contain_gem--;
			left++;
			
		}
		
		// 배열은 0부터 & 문제는 1부터이므로 그냥 증가 연산한 채로 반환
		return new int[] {left, right};
	}
}

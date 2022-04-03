import java.util.HashMap;

public class Solution_숫자문자열과_영단어 {
// https://programmers.co.kr/learn/courses/30/lessons/81301
	
	public static void main(String[] args) {
		System.out.println(solution("one4seveneight"));
		System.out.println(solution("100"));
	}

	static HashMap<String, Integer> map = new HashMap<>();
	
	static void init() {
		map.put("zero", 0);
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		map.put("four", 4);
		map.put("five", 5);
		map.put("six", 6);
		map.put("seven", 7);
		map.put("eight", 8);
		map.put("nine", 9);
	}
	
	public static int solution(String s) {
		init();
		StringBuilder ans = new StringBuilder();
		String temp = new String();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				ans.append(s.charAt(i));
			} else {
				temp += s.charAt(i);
			}
			
			if(map.containsKey(temp)) {
				ans.append(map.get(temp));
				temp = new String();
			}
			
		}
		return Integer.parseInt(ans.toString());
	}

}

/*
    public int solution(String s) {
        init();
		int answer = 0;
		String temp = new String();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) >= '1' && s.charAt(i) <= '9') {
				answer = answer * 10 + Integer.parseInt(s.substring(i, i+1));
			} else {
				temp += s.charAt(i);
			}
			
			if(map.containsKey(temp)) {
				answer = answer * 10 + map.get(temp);
				temp = new String();
			}
			
		}
		return answer;
    }
*/
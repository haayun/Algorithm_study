import java.util.HashSet;
import java.util.Set;

public class Solution_불량_사용자 {
// https://programmers.co.kr/learn/courses/30/lessons/64064
	public static void main(String[] args) {
		String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
		String[] banned_id = { "fr*d*", "abc1**" };
		System.out.println(solution(user_id, banned_id));
	}
	static Set<Integer> result;
	static int N, R;
	
	static int solution(String[] user_id, String[] banned_id) {
		
		result = new HashSet<>();
		N = user_id.length;
		R = banned_id.length;
				
		perm(0, 0, user_id, banned_id);
		
		return result.size();
	}
	
	static boolean check(String user, String banned) {
		if(user.length() != banned.length())
			return false;
		for(int i = 0; i < user.length(); i++) {
			if(banned.charAt(i) == '*') continue;
			if(banned.charAt(i) != user.charAt(i)) return false;
		}
		return true;
		
	}

	static void perm(int cnt, int bit, String[] user_id, String[] banned_id) {
		if(cnt == R) {
			result.add(bit);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if((bit & (1<<i)) == 0) {
				if(check(user_id[i], banned_id[cnt]))
					perm(cnt+1, bit | (1<<i), user_id, banned_id);
			}
		}
	}
	
}

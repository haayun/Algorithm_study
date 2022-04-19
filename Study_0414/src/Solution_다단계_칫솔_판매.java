import java.util.Arrays;
import java.util.HashMap;

public class Solution_다단계_칫솔_판매 {

	public static void main(String[] args) {
//		int[] result = solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}, new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}, new String[]{"young", "john", "tod", "emily", "mary"}, new int[]{12, 4, 2, 5, 10});
		int[] result = solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}, new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}, new String[]{"sam", "emily", "jaimie", "edward"}, new int[]{2, 3, 5, 4});
		System.out.println(Arrays.toString(result));
	}

	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int N = enroll.length;
        int[] answer = new int[N];
        HashMap<String, Integer> index = new HashMap<>();	// 각 판매원의 인덱스 정보 저장하는 맵
        HashMap<String, String> parent = new HashMap<>();	// 각 판매원의 추천인 저장하는 맵
        for(int i = 0; i < N; i++) {
        	// 맵 구성하기
        	index.put(enroll[i], i);
        	parent.put(enroll[i], referral[i]);
        }
        
        for(int i = 0; i < seller.length; i++) {
        	String cur_seller = seller[i];
        	String cur_referral = null;
        	int profit = amount[i] * 100;
        	do {
        		cur_referral = parent.get(cur_seller);	
        		int cur = index.get(cur_seller);
        		answer[cur] += profit;  	
        		if(profit < 10) break;		// 원단위에서 절사할 때 배분할 금액이 없는 경우 그냥 가진다
        		profit /= 10;
        		answer[cur] -= profit;
        		
        		cur_seller = cur_referral;	
        	} while(!cur_referral.equals("-"));		// center에 도달하면 반복문 탈출
        }
        return answer;
    }
}

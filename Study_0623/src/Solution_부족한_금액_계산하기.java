
public class Solution_부족한_금액_계산하기 {

	public static void main(String[] args) {
	}

	public static long solution(int price, int money, int count) {
        long answer = 0;
        long total = 0;
        
        for(int i = 1; i <= count; i++)
        	total += price * i;
        
        if(total > money) answer = total - money;
        
        return answer;
    }
}

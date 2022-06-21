
public class Solution_타겟_넘버 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 1, 1, 1, 1}, 3));
		System.out.println(solution(new int[] { 4, 1, 2, 1 }, 4));
	}
	
	public static int solution(int[] numbers, int target) {
			
		return dfs(0, 0, numbers, target);
		
	}
	
	static int dfs(int cnt, int sum, int[] numbers, int target) {
		if(cnt == numbers.length) {
			if(sum == target)
				return 1;
			return 0;
		}
		
		return dfs(cnt + 1, sum + numbers[cnt], numbers, target) + dfs(cnt + 1, sum - numbers[cnt], numbers, target);
		
	}

}

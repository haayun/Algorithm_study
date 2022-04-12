
public class Solution_징검다리_건너기 {
// https://programmers.co.kr/learn/courses/30/lessons/64062
	public static void main(String[] args) {
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		System.out.println(solution(stones, k));
	}
	
	static int solution(int[] stones, int k) {
        int right = 0;
        for(int i = 0; i < stones.length; i++)
        	right = Math.max(right, stones[i]);
        
        return upperSearch(stones, 1, right, k);
    }

	private static int upperSearch(int[] stones, int left, int right, int k) {
		int answer = 0;
		while(left <= right) {
			int mid = (left + right) / 2;
			int jump = dist(stones, mid);
			
			if(jump <= k) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
					
		}
		
		return answer;
	}

	private static int dist(int[] stones, int cnt) {
		int dist = 1, prev = -1;
		for(int i = 0; i < stones.length; i++) {
			if(stones[i] >= cnt) {
				dist = Math.max(dist, i - prev);
				prev = i;
			}
		}
		dist = Math.max(dist, stones.length - prev);
		return dist;
	}
	
}

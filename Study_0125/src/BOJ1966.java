import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ1966 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int max = Integer.MIN_VALUE;
			List<int[]> queue = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				queue.add(new int[] {sc.nextInt(), i});
				if(queue.get(i)[0] > max)
					max = queue.get(i)[0];
			}
			int count = 0;
			while(true) {
				boolean flag = true;
				int[] front = queue.remove(0);	// 맨 앞의 요소를 우선 제거
				
				//나머지 요소 중 front보다 중요도가 높은 게 있다면
				//맨뒤에 추가
				//없다면 제거된 상태 (count증가) + M이라면 break
				
				for(int i = 0; i < queue.size(); i++) {
					if(queue.get(i)[0] > front[0]) {
						flag = false;
						break;
					}
				}
				
				if(!flag) {
					queue.add(front);
				} else {
					count++;
					if(front[1] == M)
						break;
				}
			}
			System.out.println(count);
		}
	}

}

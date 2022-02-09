import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2805 {
	
	/*
	 * *** 이분탐색이 유형이라는 걸 알아야 풀 수 있었음 ***
	 * 이분탐색 문제
	 * 나무 리스트 정렬
	 * left는 0, right는 나무 길이 중 max
	 * list와 target의 각 차이를 합해서 M 이상이면 left 포인터 이동, 아니면 right 포인터 이동
	 * 범위 타입 확인! long!
	 */
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine(), " ");
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
			if(max < list.get(i)) max = list.get(i);
		}
		Collections.sort(list);	//반드시 정렬해야함
		int left = 0, right = max;
		while(left <= right) {
			int mid = (left + right) / 2;
			long sum = 0;
			for(int i = 0; i < N; i++) {
				int sub = list.get(i) - mid;
				if(sub <= 0) continue;
				sum += sub;
			}
			if(sum >= M) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(right);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ10816 {
	
	// *** 헷갈린 문제! ***
	// 이분탐색 활용 : 숫자 카드 입력 받아서 정렬
	// lower bound와 upper bound를 구하는 함수 정의
	// upperBound의 위치 - lowerBound의 위치 = 개수
	static ArrayList<Integer> card = new ArrayList<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++)
			card.add(Integer.parseInt(st.nextToken()));
		
		Collections.sort(card);	// 반드시 정렬해야함
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		while(m-- > 0) {
			int input = Integer.parseInt(st.nextToken());
			sb.append(upperBound(0, n-1, input) - lowerBound(0, n-1, input)).append(' ');
		}
		System.out.println(sb.toString());
	}

	public static int lowerBound(int left, int right, int target) {
		while (left <= right) {
			int mid = (left + right) / 2;
			if (card.get(mid) >= target)
				right = mid - 1;
			if (card.get(mid) < target)
				left = mid + 1;
		}
		return right + 1;
		/*
		 * right가 움직일 때는 card.get(mid)의 값이 target 이상일 때
		 * 값이 target 이상이면서 인덱스가 가장 작은 mid값이 lower bound
		 * right는 mid - 1이므로 right + 1이 lower bound가 된다
		 */
	}

	public static int upperBound(int left, int right, int target) {
		while(left <= right) {
			int mid = (left + right) / 2;
			if(card.get(mid) > target)
				right = mid - 1;
			if(card.get(mid) <= target)
				left = mid + 1;
		}
		return right + 1;
		/*
		 * break 직전 left와 right는 같은 곳을 가리킨다
		 * right(mid)가 가리키는 값은 target 이하기 때문에 left포인터가 이동하고 break
		 * 이 때의 left값은 target을 처음으로 초과하는 upper bound이고
		 * 직전에 left와 right 위치가 같았으므로 right + 1 == left
		 */
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2343 {

	static int N, M;
	static int[] lecture;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		lecture = new int[N];
		int left = 0, right = 0;
		st = new StringTokenizer(br.readLine(), " ");
		
		// 입력 
		for (int i = 0; i < N; i++) {
			lecture[i] = Integer.parseInt(st.nextToken());
			left = Math.max(left, lecture[i]);
			right += lecture[i];
		}

		// 이분탐색  
		int ans = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			int cnt = countBR(mid);

			if (cnt <= M) {
				right = mid - 1;
				ans = mid;
			} else {
				left = mid + 1;
			}
		}
		
		// 출력  
		System.out.println(ans);

	}

	// 블루레이 크기에 대해 몇 개가 필요한지 계산  
	static int countBR(int size) {
		int len = 0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (len + lecture[i] > size) {
				len = 0;
				cnt++;
			}
			len += lecture[i];
		}
		return cnt + 1;

	}

}

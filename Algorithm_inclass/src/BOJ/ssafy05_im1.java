package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
5
5 2 3
7 3 4 1 5
7 6 1
1 2 3 4 5 6 7
9 4 5
9 8 7 6 5 4 3 2 1
20 12 8
1 1 3 3 2 2 4 4 6 6 5 5 7 7 9 9 8 8 11 11
50 31 19
61 792 207 646 338 282 952 392 161 700 552 198 694 635 725 719 868 189 537 933 448 887 22 997 177 192 327 463 664 13 76 105 396 518 702 41 713 865 748 530 946 182 318 862 637 3 872 701 975 664

output
#1 29
#2 63
#3 95
#4 447
#5 226521

 */

// 우선순위 큐 사용 가넝 
public class ssafy05_im1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M1 = Integer.parseInt(st.nextToken());
			int M2 = Integer.parseInt(st.nextToken());

			int min = Math.min(M1, M2);
			int max = Math.max(M1, M2);

			Integer[] arr = new Integer[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			Arrays.sort(arr, Collections.reverseOrder());
			int ans = 0;
			for (int i = 1; i <= min; i++) {
				ans += arr[(i - 1) * 2] * i;
				ans += arr[(i - 1) * 2 + 1] * i;

			}
			for (int i = min + 1; i <= max; i++) {
				ans += arr[(min) * 2 - 1 + i - min] * i;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

}

package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
5
5
1 1 0 0 1
6
0 1 1 1 0 0
7
1 1 1 1 1 1 1
10
0 1 0 1 0 1 0 1 0 1
20
0 0 0 0 1 0 0 1 0 1 0 1 0 1 0 1 1 1 0 0

output
#1 3
#2 2
#3 1
#4 1
#5 8
 */
public class ssafy06_im1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N + 1];
			int[] target = new int[N + 1];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <= N; i++) {
				target[i] = Integer.parseInt(st.nextToken());
			}
			int cnt = 0;
			for(int i = 1; i <= N; i++) {
				if(arr[i] == target[i]) continue;
				cnt++;
				for(int j = i; j <= N; j += i) {
					arr[j] = (arr[j] + 1) % 2;
				}
			}
			System.out.println("#" + tc + " " + cnt);
			
		}
	}

}

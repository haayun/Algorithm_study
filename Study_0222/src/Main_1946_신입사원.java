import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1946_신입사원 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int[][] grades = null;
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			grades = new int[N][2];
			// 입력  
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				grades[i][0] = Integer.parseInt(st.nextToken());
				grades[i][1] = Integer.parseInt(st.nextToken());
				
			}
			// 연산 
			Arrays.sort(grades, (o1, o2) ->	 o1[0] - o2[0]);

			int cnt = 1, temp = grades[0][1];
			for(int i = 1; i < N; i++) {
				if(temp > grades[i][1]) {
					cnt++;
					temp = grades[i][1];
				}
			}
			// 출력 
			System.out.println(cnt);
		}
	}

}

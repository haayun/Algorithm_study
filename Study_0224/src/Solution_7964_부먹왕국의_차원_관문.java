import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_7964_부먹왕국의_차원_관문 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int[] map = new int[N+1];
			
			// 0번 위치도 차원 관문이 존재한다.
			map[0] = 1;
			
			// 입력 
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= N; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}

			// 연산 
			int ans = 0;
			for (int i = 0; i <= N; ) {
				// 0이면 차원관문을 설치한다. 
				if(map[i] == 0) {
					ans++;
//					map[i] = 1;
				}
				// 차원 관문에서 거리가 D 이하인 도시들 중 마지막 1인 도시로 이동 
				for(int j = i; j < i + D && j <= N; j++) {
					if(map[j] == 1) i = j;
				}
				
				i += D;
				
				
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		// 출력 
		System.out.println(sb);
	}

}

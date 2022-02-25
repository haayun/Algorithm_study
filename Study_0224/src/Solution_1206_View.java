import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1206_View {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		System.setIn(new FileInputStream("input_view.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			int[] buildings = new int[N];
			for (int i = 0; i < N; i++)
				buildings[i] = Integer.parseInt(st.nextToken());
			
			int ans = 0, max;
			
			for (int i = 0; i < N; i++) {
				max = 0;
				for(int j = i - 2; j <= i + 2; j++) {
					if(j < 0 || j >= N || j == i) continue;
					max = Math.max(max, buildings[j]);
				}
				ans += (buildings[i] > max ? buildings[i] - max : 0);
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);

	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1220_Magnetic {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		System.setIn(new FileInputStream("input_magnetic.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] magnets = new int[N][N];
			for (int i = 0; i < N; i++) {				
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++)
					magnets[i][j] = Integer.parseInt(st.nextToken());
				
			}
			
			int ans = 0, temp, cnt;
			for(int j = 0; j < N; j++) {
				temp = 2; cnt = 0;
				for(int i = 0; i < N; i++) {
					if(magnets[i][j] == 0) continue;
					if(magnets[i][j] != temp) cnt++;
						
					temp = magnets[i][j];
				}
				ans += cnt/2;
					
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);

	}

}

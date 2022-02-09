import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ7568 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] body = new int[N][3];
		
		StringTokenizer st = null;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			body[i][0] = Integer.parseInt(st.nextToken());
			body[i][1] = Integer.parseInt(st.nextToken());
			body[i][2] = 1;
		}
		
		//구현
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				if(body[i][0] < body[j][0] && body[i][1] < body[j][1])
					body[i][2]++;
			}
		}
		
		//출력
		for(int i = 0; i < N; i++)
			System.out.println(body[i][2]);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2564 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int w = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(br.readLine());
		int[][] stores = new int[num][2];
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			stores[i][0] = Integer.parseInt(st.nextToken());
			stores[i][1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		int news = Integer.parseInt(st.nextToken()), loca = Integer.parseInt(st.nextToken());
		
		int[] vertex = new int[4];
	}
}

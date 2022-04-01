package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074_2 {
static boolean found = false;
static int ans = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()) + 1, r = Integer.parseInt(st.nextToken()),
				c = Integer.parseInt(st.nextToken());
		
		System.out.println(getZ(N, r, c));
		

	}
	static int getZ(int n, int x, int y) {
		if(n == 0) return 0;
		
		int cnt = 0;
		int place;
		if(0 <= x && x < 1<<(n-1)) {
			if(0 <= y && y < (1<<(n-1)))
				place = 0;
			else {
				place = 1;
				y -= 1<<(n-1);
			}
		}
		else {
			if(0 <= y && y < (1<<(n-1)))
				place = 2;
			else {
				place = 3;
				y -= 1<<(n-1);
			}
			x -= 1<<(n-1);
		}
		
		cnt += ((1<<(n-1)) * (1<<(n-1)) * place);
		cnt += getZ(n-1, x, y);
		
		return cnt;
	}
}

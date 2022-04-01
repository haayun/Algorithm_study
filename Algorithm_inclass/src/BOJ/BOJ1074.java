package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {
static boolean found = false;
static int ans = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()) + 1, r = Integer.parseInt(st.nextToken()),
				c = Integer.parseInt(st.nextToken());
		
		divide(r, c, 0, 0, 1 << N);
		
		System.out.println(ans);

	}
	static void divide(int r, int c, int row, int col, int size) {
		if(row == r &&col == c) {
			found = true;
			return;
		}
		if (found) return;
		
		if(r < row || r >= row + size ||c < col || c>= col+size) {
			ans += size * size;
			return;
		}
		
		int next_size = size/2;
		for(int i = 0; i <= next_size; i+=next_size) {
			for(int j= 0; j<= next_size; j+=next_size)
				divide(r, c, row+i, col+j, next_size);
		}
	}
}

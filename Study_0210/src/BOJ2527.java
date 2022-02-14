import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2527 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 0; tc < 4; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken()),
					p1 = Integer.parseInt(st.nextToken()), q1 = Integer.parseInt(st.nextToken()),
					x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken()),
					p2 = Integer.parseInt(st.nextToken()), q2 = Integer.parseInt(st.nextToken());

			// 겹치지 않는 경우
			if ((p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1)) {
				System.out.println("d");
			}
			// 점
			else if ((p1 == x2 && y1 == q2) || (p2 == x1 && y2 == q1) || (p1 == x2 && q1 == y2)
					|| (p2 == x1 && q2 == y1)) {
				System.out.println("c");
			}
			// 선분
			else if ((x2 == p1 && q1 != y2) || (x1 == p2 && q2 != y1) || (y1 == q2 && p2 != x1)
					|| (y2 == q1 && p1 != x2)) {
				System.out.println("b");
			}
			// 직사각형
			else {
				System.out.println("a");
			}

		}
	}

}

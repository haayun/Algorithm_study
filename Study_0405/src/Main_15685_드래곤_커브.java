import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15685_드래곤_커브 {

	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { 1, 0, -1, 0 };
	static boolean[][] selected;	
	static ArrayList<Integer> dir;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		selected = new boolean[101][101];

		for (int i = 0; i < N; i++) {
			// 입력
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()), g = Integer.parseInt(st.nextToken());
			
			// 회전 정보 
			dir = new ArrayList<>();
			Point end = new Point(x + dx[d], y + dy[d]);
			// 0세대 처리
			selected[y][x] = selected[end.y][end.x] = true;
			dir.add(d);
			while(g-- > 0) {
				// 마지막 위치를 반환받기
				end = curve(end);
			}
			
		}
		
		System.out.println(countSquare());

	}

	static Point curve(Point end) {
		for(int i = dir.size() - 1; i >= 0; i--) {
			int nd = (dir.get(i) + 1) % 4;
			end = new Point(end.x + dx[nd], end.y + dy[nd]);
			selected[end.y][end.x] = true;
			dir.add(nd);
		}
		return end;
	}
	
	static int countSquare() {
		int cnt = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0;j < 100; j++) {
				if(selected[i][j] && selected[i+1][j] && selected[i][j+1] && selected[i+1][j+1])
					cnt++;
			}
		}
		return cnt;
	}

}

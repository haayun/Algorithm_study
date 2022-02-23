import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {

	static int N, M, chicken_cnt, house_cnt, ans;
	static int[][] map;
	static Point[] chicken, house, p;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		chicken = new Point[13];
		house = new Point[2 * N];
		p = new Point[M];

		chicken_cnt = 0;
		house_cnt = 0;
		ans = Integer.MAX_VALUE;
		
		// 입력 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					chicken[chicken_cnt++] = new Point(i, j);
				else if (map[i][j] == 1)
					house[house_cnt++] = new Point(i, j);
			}
		}
		
		// 연산 
		combi(0, 0);
		
		// 출력 
		System.out.println(ans);
	}
	
	// 치킨집 조합 
	static void combi(int cnt, int start) {
		if (cnt == M) {
			// 조합 완성 시 치킨 거리 합 계산 
			int temp = 0;
			for(int i = 0; i< house_cnt; i++) {
				int dist = Integer.MAX_VALUE;
				for(int j = 0; j< M; j++) {
					dist = Math.min(dist, Math.abs(house[i].x - p[j].x) + Math.abs(house[i].y - p[j].y));
				}
				temp += dist;
			}
			
			// 최소 치킨 거리 갱신  
			ans = Math.min(ans, temp);
			return;
		}

		for (int i = start; i < chicken_cnt; i++) {
			p[cnt] = chicken[i];
			combi(cnt + 1, i + 1);
		}
	}

}

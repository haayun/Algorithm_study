package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15683 {
	static int[][] map, save;
	static int N, M, min = Integer.MAX_VALUE;
	static ArrayList<int[]> cctvs;
	// 상 우 하 좌
	static int[][] d = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M]; save = new int[N][M];
		cctvs = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6)
					cctvs.add(new int[] { i, j });
			}
		}
		dfs(0);
		System.out.println(min);

	}

	static void dfs(int cnt) {

		if (cnt == cctvs.size()) {
			// 사각지대 최소 크기 갱신하기
			int temp =0;
			for(int i =0; i < N; i++) {
				for(int j = 0; j< M; j++) {
					if(map[i][j] == 0)
						temp++;
					System.out.print(map[i][j] +" ");
				}
				System.out.println();
			}
			System.out.println();
			min = Math.min(min, temp);
			return;
		}
		
		int r = cctvs.get(cnt)[0], c = cctvs.get(cnt)[1];
		
		for(int i = 0; i < 4; i++) {
			copy(save, map);
			putCctv(r, c, map[r][c], i);
			dfs(cnt+1);
			copy(map, save);
			
			if((map[r][c] == 2 && i == 1) || (map[r][c] == 5 && i == 0))
				break;
		}

	}

	static void putCctv(int r, int c, int cctv, int dir) {
		if(cctv >= 1) {	// 1, 2, 3, 4, 5: dir 감시 
			monitor(r, c, dir);
		}
		if(cctv >= 2 && cctv != 3) { 	// 2, 4, 5: dir + 2 감시 
			monitor(r, c, (dir+2) % 4);
		}
		if(cctv >= 3) {		// 3, 4, 5: dir + 1 감시 
			monitor(r, c, (dir+1) % 4);
		}
		if(cctv == 5) {		// 5: dir + 3 감시 
			monitor(r, c, (dir+3) % 4);
		}
	}
	
	static void monitor(int r, int c, int dir) {
		int nr = r + d[dir][0], nc = c + d[dir][1];
		
		while(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 6) {
			if(map[nr][nc] == 0)
				map[nr][nc] = 7;
			nr += d[dir][0];
			nc += d[dir][1];
		}
	}
	
	static void copy(int[][] obj, int[][] origin) {
		for(int i =0; i <N; i++) {
			for(int j =0; j<M; j++)
				obj[i][j] = origin[i][j];
		}
	}

}

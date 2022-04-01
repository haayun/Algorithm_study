package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 시간 : 268
 * 메모리 : 54380
 */
public class BOJ15683_2 {
	
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
		int[][] map = new int[N][M]; 
		cctvs = new ArrayList<>();

		// 입력 + cctv에 삽입  
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6)
					cctvs.add(new int[] { i, j });
			}
		}
		// 연산  
		dfs(0, map);
		
		// 출력 
		System.out.println(min);

	}

	static void dfs(int cnt, int[][] map) {

		if (cnt == cctvs.size()) {	// cctv	감시 영역 모두 구성했다면  
			// 사각지대 최소 크기 갱신하기
			int temp =0;
			for(int i =0; i < N; i++) {
				for(int j = 0; j< M; j++) {
					if(map[i][j] == 0)
						temp++;
				}
			}
			min = Math.min(min, temp);
			return;
		}
		
		// 현재 cctv 위치   
		int r = cctvs.get(cnt)[0], c = cctvs.get(cnt)[1];
		
		// 방향 지정하기 
		for(int i = 0; i < 4; i++) {
			int[][] copy = new int[N][M];
			// map 복제 
			copy(copy, map);
			// copy에 cctv 감시 영역 구성
			putCctv(r, c, i, copy);
			// 다음 cctv 놓기 
			dfs(cnt+1, copy);
			
			// 2번 cctv는 2번만, 5번 cctv는 1번만 방향을 바
			if((map[r][c] == 2 && i == 1) || (map[r][c] == 5 && i == 0))
				break;
		}

	}

	static void putCctv(int r, int c, int dir, int[][] map) {
		int cctv = map[r][c];
		if(cctv >= 1) {	// 1, 2, 3, 4, 5: dir 감시 
			monitor(r, c, dir, map);
		}
		if(cctv >= 2 && cctv != 3) { 	// 2, 4, 5: dir + 2 감시 (반대)
			monitor(r, c, (dir+2) % 4, map);
		}
		if(cctv >= 3) {		// 3, 4, 5: dir + 1 감시 (90도)
			monitor(r, c, (dir+1) % 4, map);
		}
		if(cctv == 5) {		// 5: dir + 3 감시 (270도)  
			monitor(r, c, (dir+3) % 4, map);
		}
	}
	
	static void monitor(int r, int c, int dir, int[][] map) {
		// 해당 방향에 감시 영역 구성하기 
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

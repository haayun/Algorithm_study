import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6593_상범_빌딩 {
	
	static class unit {
		int l, r, c;
		
		unit(int l, int r, int c){
			this.l = l;
			this.r = r;
			this.c = c;
		}
	}

	
	static int[][] d = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		char[][][] building;
		
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken()); 
			
			// 테케 종료 조건
			if(L == 0 && R == 0 && C == 0) break;
			
			building = new char[L][R][C];
			unit start = null, end = null;

			// 입력
			for(int i = 0; i < L; i++) {
				for(int j = 0; j < R; j++) {
					building[i][j] = br.readLine().toCharArray();
					for(int k = 0; k < C; k++) {
						if(building[i][j][k] == 'S') start = new unit(i, j, k);
						if(building[i][j][k] == 'E') end = new unit(i, j, k);
					}
				}
				br.readLine();
			}
			
			// bfs
			int[][][] visited = new int[L][R][C];
			Queue<unit> queue = new LinkedList<>();
			
			queue.offer(start);
			visited[start.l][start.r][start.c] = 1; 
			
			while(!queue.isEmpty()) {
				
				unit cur = queue.poll();
//				if(cur.l == end.l && cur.r == end.r && cur.c == end.c) break;
				if(cur == end) break;
				
				for(int i = 0; i < d.length; i++) {
					int nl = cur.l+d[i][0], nr = cur.r+d[i][1], nc = cur.c+d[i][2];
					if(nl < 0 || nl >= L || nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nl][nr][nc] > 0 || building[nl][nr][nc] == '#') continue;
					
					queue.offer(new unit(nl, nr, nc));
					visited[nl][nr][nc] = visited[cur.l][cur.r][cur.c]+ 1;
					
				}
			}
			
			// 출력
			if(visited[end.l][end.r][end.c] == 0)
				sb.append("Trapped!\n");
			else {
				sb.append("Escaped in ").append(visited[end.l][end.r][end.c] - 1).append(" minute(s).\n");	
			}
		}
		System.out.println(sb);
	}

}

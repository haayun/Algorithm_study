import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_21608_상어_초등학교 {

	static int N;
	static int[][] d = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] map, likes;
	static int[] satisfy = {0, 1, 10, 100, 1000};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		likes = new int[N * N + 1][4];
		int[] order = new int[N * N + 1];
		
		// 입력받아 앉히기 
		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int index = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 4; j++) {
				likes[index][j] = Integer.parseInt(st.nextToken());
			}
			sit(index);
		}
		
		// 만족도 계산하기 
		int ans = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int cnt = 0;
				for (int[] delta : d) {
					int nr = i +delta[0], nc = j + delta[1];
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					
					for(int friend : likes[map[i][j]]) 
						if(map[nr][nc] == friend) cnt++;
				}
				ans += satisfy[cnt];
			}
		}
		System.out.println(ans);
		
	}
	static class Seat implements Comparable<Seat>{
		int r, c;
		int like, empty;
		Seat(int r, int c){
			this.r = r;
			this.c = c;
			like = 0;
			empty = 0;
		}
		// 조건대로 정렬 
		@Override
		public int compareTo(Seat o) {
			// TODO Auto-generated method stub
			if(this.like != o.like) return o.like - this.like;
			if(this.empty != o.empty) return o.empty - this.empty;
			if(this.r != o.r) return this.r - o.r;
			return this.c - o.c;
		}
	}

	public static void sit(int student) {

		PriorityQueue<Seat> available = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) continue;
				Seat seat = new Seat(i, j);
				for (int[] delta : d) {
					int nr = i + delta[0], nc = j + delta[1];
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					
					if(map[nr][nc] == 0) {
						seat.empty++;
						continue;
					}
					for(int friend : likes[student]) {
						if(map[nr][nc] == friend) seat.like++;
					}
				}
				available.add(seat);
			}
		}
		map[available.peek().r][available.peek().c] = student;
	}
}

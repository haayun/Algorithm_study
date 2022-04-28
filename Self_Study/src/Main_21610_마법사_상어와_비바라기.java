
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_21610_마법사_상어와_비바라기 {

	static class Basket {
		boolean prev = false;
		int water;

		Basket(int water) {
			this.water = water;
		}
	}

	static int[] dr = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int N;
	static Basket[][] map;
	static int[][] mask;
	static ArrayList<Point> clouds;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new Basket[N][N];
		mask = new int[N][N];
		clouds = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = new Basket(Integer.parseInt(st.nextToken()));
			}
		}

		clouds.add(new Point(N-1, 0));
		clouds.add(new Point(N-1, 1));
		clouds.add(new Point(N-2, 0));
		clouds.add(new Point(N-2, 1));
		int cnt = 4;
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < cnt; i++) {
				Point cloud = clouds.get(i);
				move(cloud.x, cloud.y, d, s);	
			}
			for(int i = cnt; i < cnt * 2; i++) {
				Point cloud = clouds.get(i);
				bug(cloud.x, cloud.y);
			}
			clouds.clear();
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j].water += mask[i][j];
					mask[i][j] = 0;
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j].prev) {
						map[i][j].prev = false;
						continue;
					}
					if(map[i][j].water >= 2) {
						clouds.add(new Point(i, j));
						map[i][j].water -= 2;
					}
				}
			}
			cnt = clouds.size();
		}
		int answer = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				answer += map[i][j].water;
			}
		}
		System.out.println(answer);
	}

	static void move(int r, int c, int d, int s) {
		
		int nr = (r + dr[d] * (s % N)) % N;
		int nc = (c + dc[d] * (s % N)) % N;
		if(nr < 0) nr += N;
		if(nc < 0) nc += N;
		
		map[nr][nc].water++;
		map[nr][nc].prev = true;
		clouds.add(new Point(nr, nc));
	}
	
	static void bug(int r, int c) {

		int increase = 0;
		for(int i = 2; i <= 8; i+=2) {
			int bugR = r + dr[i];
			int bugC = c + dc[i];
			if(bugR < 0 || bugR >= N || bugC < 0 || bugC >= N) continue;
			if(map[bugR][bugC].water > 0) {
				increase++;
			}
		}
		
//		map[r][c].water += increase;
		mask[r][c] = increase;
	}
}

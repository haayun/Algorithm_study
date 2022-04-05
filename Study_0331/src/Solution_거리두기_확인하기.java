import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_거리두기_확인하기 {
// https://programmers.co.kr/learn/courses/30/lessons/81302
	public static void main(String[] args) {
		String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
		int[] result = solution(places);
		System.out.println(Arrays.toString(result));
	}

	static char[][] map;
	static ArrayList<Point> people;
	static int[][] area;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int[] solution(String[][] places) {
		int[] answer = new int[places.length];
		
		map = new char[5][5];
		for(int tc = 0; tc < places.length; tc++) {
			people = new ArrayList<>();
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 5; j++) {
					map[i][j] = places[tc][i].charAt(j);
					if(map[i][j] == 'P') people.add(new Point(i, j));
				}
			}		
			
			// 모든 응시자에 대해 확인
			boolean flag = true;
			outer : for(int i = 0; i < people.size() - 1; i++) {
				for(int j = i + 1; j < people.size(); j++) {
					if(!flag) break outer;	// 이미 거리두기를 한명이라도 지키지 않았다면 더 고려할 필요 없다
					
					// 맨해튼 거리 3 이상이면 OK
					int dist = Math.abs(people.get(i).x - people.get(j).x) + Math.abs(people.get(i).y - people.get(j).y);
					if(dist >= 3) continue;
					// 2 이하인 경우
					// 파티션을 거치지 않고 가는 거리가 2 초과거나 다른 구역에 있으면 OK
					else {
						area = new int[5][5];
						bfs(people.get(i).x, people.get(i).y, people.get(j).x, people.get(j).y);
						// 초기에 1부터 시작해서 조건을 3 초과로
						if (area[people.get(j).x][people.get(j).y] > 3 || area[people.get(j).x][people.get(j).y] == 0) continue;
						else {
							flag = false;
						}
					}
				}
			}
			answer[tc] = flag ? 1 : 0;
		}
		return answer;
	}
	

	static void bfs(int r, int c, int tr, int tc) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c));
		area[r][c] = 1;
		while(!queue.isEmpty()) {
			int cr = queue.peek().x, cc = queue.peek().y;
			queue.poll();
			for(int d = 0; d < 4; d++) {
				int nr = cr + dr[d], nc = cc + dc[d];
				if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || map[nr][nc] == 'X' || area[nr][nc] != 0) continue;
				queue.offer(new Point(nr, nc));
				area[nr][nc] = area[cr][cc] + 1;
			}
		}
	}
	
}

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_베스트앨범 {

	public static void main(String[] args) {
		int[] res = solution(new String[] { "classic", "pop", "classic", "classic", "pop" },
				new int[] { 500, 600, 150, 800, 2500 });
		System.out.println(Arrays.toString(res));
	}

	static class Play implements Comparable<Play> {
		int idx;	// return할 고유번호
		int cnt;	// 재생횟수

		Play(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Play o) {
			// 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
			if (this.cnt != o.cnt)
				return o.cnt - this.cnt;
			// 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
			return this.idx - o.idx;
		}

	}

	public static int[] solution(String[] genres, int[] plays) {
		int[] answer = new int[200];
		
		HashMap<String, Point> map = new HashMap<>();
		ArrayList<Play>[] list = new ArrayList[genres.length];
		
		for(int i = 0; i < genres.length; i++)
			list[i] = new ArrayList<>();
		
		int gIdx = 0;
		for(int i = 0; i < genres.length; i++) {
			if(!map.containsKey(genres[i])){
				map.put(genres[i], new Point(gIdx++, 0));
			}
			
			map.get(genres[i]).y += plays[i];
			
			list[map.get(genres[i]).x].add(new Play(i, plays[i]));
			
		}
		
		// 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다. (map -> list -> sort)
		List<Point> valueList = map.values().stream().collect(Collectors.toCollection(ArrayList::new));
		
		Collections.sort(valueList, (s1, s2) -> s2.y - s1.y);
		
		// 2, 3. 각 장르에 해당하는 plays 리스트를 정렬 -> answer에 추가
		int ansCnt = 0;
		for (Point point : valueList) {
			int idx = point.x;
			
			// 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
			if(list[idx].size() < 2) {
				answer[ansCnt++] = list[idx].get(0).idx;
				continue;
			}
			
			Collections.sort(list[idx]);
			
			for(int i = 0; i < 2; i++) {
				answer[ansCnt++] = list[idx].get(i).idx;
			}
			
		}
		
		// ansCnt개로 array를 잘라서 return
		return Arrays.copyOfRange(answer, 0, ansCnt);
	}
}

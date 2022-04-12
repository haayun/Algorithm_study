import java.util.Arrays;
import java.util.HashMap;

public class Solution_호텔_방_배정 {
// https://programmers.co.kr/learn/courses/30/lessons/64063
	
	public static void main(String[] args) {
		long[] result = solution(10, new long[]{1, 3, 4, 1, 3, 1});
		System.out.println(Arrays.toString(result));
	}
	
	static HashMap<Long, Long> map= new HashMap<>();
	
	static long[] solution(long k, long[] room_number) {
		long[] answer = new long[room_number.length];
		
		for(int i = 0; i < room_number.length; i++) {
			answer[i] = findVal(room_number[i]);
		}
		
		return answer;
	}
	
	static long findVal(long room) {
		if (!map.containsKey(room)) {
			map.put(room, room + 1);
			return room;
		}
		long nextRoom = findVal(map.get(room));
		map.put(room, nextRoom);
		return nextRoom;
	}
}

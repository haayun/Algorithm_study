import java.util.Arrays;

public class Solution_셔틀버스 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(1, 1, 5, new String[] { "08:00", "08:01", "08:02", "08:03" });
		System.out.println("---------");
		solution(2, 10, 2, new String[] { "09:10", "09:09", "08:00" });
		System.out.println("---------");
		solution(2, 1, 2, new String[] { "09:00", "09:00", "09:00", "09:00" });
	}

	public static String solution(int n, int t, int m, String[] timetable) {
		int size = timetable.length;
		int[] crew = new int[size];

		for (int i = 0; i < size; i++) {
			crew[i] = toInt(timetable[i]);
		}

		Arrays.sort(crew);

		int shuttle = toInt("09:00") - t;

		int last_time = 0, index = 0, rode = 0;

		for (int i = 0; i < n; i++) {
			shuttle += t;
			rode = 0;
			
			while(rode < m) {
				if(index < size && crew[index] <= shuttle) {
					rode++;
					last_time = crew[index++]; 
				} else break;
			}
		}
		
		String answer = "";
		if(rode == m) answer = toString(last_time-1);
		else if(rode < m) answer = toString(shuttle);
		return answer;
	}

	static int toInt(String time) {
		// 시각을 분으로 계산 후 반환
		String[] t = time.split(":");
		int hour = Integer.parseInt(t[0]), minute = Integer.parseInt(t[1]);
		return hour * 60 + minute;
	}

	static String toString(int minute) {
		StringBuilder sb = new StringBuilder();

		int hour = minute / 60;
		if (hour < 10)
			sb.append("0");
		sb.append(hour).append(":");

		int min = minute % 60;
		if (min < 10)
			sb.append("0");
		sb.append(min);

		return sb.toString();
	}
}

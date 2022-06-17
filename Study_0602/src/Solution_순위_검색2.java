import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_순위_검색2 {

	public static void main(String[] args) {
		int[] answer = solution(
				new String[] { "java backend junior pizza 150", "python frontend senior chicken 210",
						"python frontend senior chicken 150", "cpp backend senior pizza 260",
						"java backend junior chicken 80", "python backend senior chicken 50" },
				new String[] { "java and backend and junior and pizza 100",
						"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
						"- and backend and senior and - 150", "- and - and - and chicken 100",
						"- and - and - and - 150" });
		System.out.println(Arrays.toString(answer));
	}

	static Map<String, List<Integer>> map = new HashMap<>();
	static boolean[] selected = new boolean[4];

	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];

		String[] infos = new String[5];
		for (int i = 0; i < info.length; i++) {
			StringTokenizer st = new StringTokenizer(info[i]);
			for (int j = 0; j < 5; j++) {
				infos[j] = st.nextToken();
			}
			comb(infos, 0);
		}

		for (String key : map.keySet()) {
			Collections.sort(map.get(key));
		}

		for (int i = 0; i < query.length; i++) {
			String curr = query[i].replace("and", "");
			StringTokenizer st = new StringTokenizer(curr);
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < 4; j++) {
				String tmp = st.nextToken();
				if (!tmp.equals("-"))
					sb.append(tmp);
			}
			int score = Integer.parseInt(st.nextToken());
			List<Integer> list = map.getOrDefault(sb.toString(), new ArrayList<Integer>());
			int left = 0, right = list.size();

			while (left < right) {
				int mid = (left + right) / 2;
				if (list.get(mid) < score) left = mid + 1;
				else right = mid;
			}

			answer[i] = list.size() - left;
		}

		return answer;
	}

	static void comb(String[] info, int cnt) {
		if (cnt == 4) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 4; i++) {
				if (selected[i])
					sb.append(info[i]);
			}
			map.put(sb.toString(), map.getOrDefault(sb.toString(), new ArrayList<Integer>()));
			map.get(sb.toString()).add(Integer.parseInt(info[4]));
			return;
		}

		selected[cnt] = true;
		comb(info, cnt + 1);
		selected[cnt] = false;
		comb(info, cnt + 1);
	}
}

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_순위_검색 {

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

	
	
	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		Map<String, Integer>[] condition = setCondition();
		
		int[][] infoScore = new int[info.length][5];
		StringTokenizer st;
		for(int i = 0; i < info.length; i++) {
			st = new StringTokenizer(info[i]);
			for(int j = 0; j < 4; j++)
				infoScore[i][j] = condition[j].get(st.nextToken());
			infoScore[i][4] = Integer.parseInt(st.nextToken());
		}
		
		int[] queryScore = new int[5];
		for(int i = 0; i < query.length; i++) {
			st = new StringTokenizer(query[i]);
			for(int j = 0; j < 4; j++) {
				queryScore[j] = condition[j].get(st.nextToken());
				if(j < 3) st.nextToken();
			}
			queryScore[4] = Integer.parseInt(st.nextToken());
			int cnt = 0;
			outer : for(int j= 0; j < info.length; j++) {
				for(int k = 0; k < 4; k++) {
					if(queryScore[k] != 0 && queryScore[k] != infoScore[j][k]) {
						continue outer;
					}
				}
				if(queryScore[4] <= infoScore[j][4]) cnt++;
				
			}
			answer[i] = cnt;
		}
		
		return answer;
	}
	static Map<String, Integer>[] setCondition() {
		Map<String, Integer>[] condition = new HashMap[4];
		condition[0] = new HashMap<String, Integer>();
		condition[0].put("-", 0);
		condition[0].put("cpp", 1);
		condition[0].put("java", 2);
		condition[0].put("python", 3);
		
		condition[1] = new HashMap<String, Integer>();
		condition[1].put("-", 0);
		condition[1].put("backend", 1);
		condition[1].put("frontend", 2);
		
		condition[2] = new HashMap<String, Integer>();
		condition[2].put("-", 0);
		condition[2].put("junior", 1);
		condition[2].put("senior", 2);
		
		condition[3] = new HashMap<String, Integer>();
		condition[3].put("-", 0);
		condition[3].put("chicken", 1);
		condition[3].put("pizza", 2);
		return condition;
	}
}

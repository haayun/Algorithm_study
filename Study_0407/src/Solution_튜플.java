import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Solution_튜플 {
// https://programmers.co.kr/learn/courses/30/lessons/64065
	public static void main(String[] args) {
		int[] answer = solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
		System.out.println(Arrays.toString(answer));
	}
	
	static int[] solution(String s) {
        StringTokenizer st = new StringTokenizer(s, ",|{|}");
        HashMap<Integer, Integer> map = new HashMap<>();
        
        while(st.hasMoreTokens()) {
        	int key = Integer.parseInt(st.nextToken());
        	if(map.containsKey(key))
        		map.replace(key, map.get(key)+1);
        	else
        		map.put(key, 1);
        }
        
        ArrayList<Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        int[] answer = new int[list.size()];
        
        Collections.sort(list, (e1, e2) -> e2.getValue() - e1.getValue());
        
        for(int i =0; i< list.size(); i++) {
        	answer[i] = list.get(i).getKey();
        }
        
        return answer;
    }

}

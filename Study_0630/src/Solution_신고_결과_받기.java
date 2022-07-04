import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution_신고_결과_받기 {

	public static void main(String[] args) {
		
	}
	public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        
        HashMap<String, Integer> idx = new HashMap<>();
        for(int i = 0; i < n; i++)
            idx.put(id_list[i], i);
        
        HashSet<Integer>[] reported = new HashSet[n];
        for(int i = 0; i < n; i++)
            reported[i] = new HashSet<>();
        
        StringTokenizer st;
        for(int i = 0; i < report.length; i++){
            st = new StringTokenizer(report[i]);
            String from = st.nextToken();
            String to = st.nextToken();
            reported[idx.get(to)].add(idx.get(from));
        }
        
        int[] mail = new int[n];
        
        for(int i = 0; i < n; i++){
            if(reported[i].size() < k) continue;
            Iterator<Integer> it = reported[i].iterator();
            while(it.hasNext()) {
                mail[it.next()]++;
            }
        }
        
        return mail;
    }
	
}

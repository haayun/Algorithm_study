import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13335 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		
		int[] trucks = new int[n];
		for (int i = 0; i < n; i++) {
			trucks[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0, sum = 0, ans = 0;
		Queue<Integer> bridge = new LinkedList<>();	
		
		for(int i = 0; i < w; i++)
			bridge.offer(0);
		
		while(!bridge.isEmpty()) {
			ans++;
			sum -= bridge.poll();
			
			if(cnt < n) {
				if(sum + trucks[cnt] <= L) {
					sum += trucks[cnt];
					bridge.offer(trucks[cnt++]);
				} else {
					bridge.offer(0);
				}				
			}
		}
		
		System.out.println(ans);
	}

}

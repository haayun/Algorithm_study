import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_15787_기차가_어둠을_헤치고_은하수를 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

		int[] trains = new int[N + 1];
		int cmd, t, x = 0;
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			cmd = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			if (cmd < 3)
				x = Integer.parseInt(st.nextToken()) - 1;	// 0번부터 시작하도록 
			
			if(cmd == 1)
				trains[t] |= 1 << x;
			else if (cmd == 2)
				trains[t] &= ~(1 << x);
			else if (cmd == 3) {
				trains[t] = trains[t] << 1;
				trains[t] &= (1<<20) - 1;
			}
			else {
				trains[t]= trains[t] >> 1;
			}
		}

		Set<Integer> set = new HashSet<>();
		for (int i = 1; i < N+1; i++) {
			set.add(trains[i]);
//			System.out.println(Integer.toBinaryString(trains[i]));
		}
		
		System.out.println(set.size());
	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> cards = new LinkedList<Integer>();
		for(int i = 0; i < N; i++)
			cards.add(i+1);
	
		int cnt = 0;
		while(cards.size() > 1) {
			if(cnt % 2 == 0) {
				cards.poll();
			} else {
				cards.add(cards.poll());
			}
			cnt++;
		}
		System.out.print(cards.peek());
	}

}

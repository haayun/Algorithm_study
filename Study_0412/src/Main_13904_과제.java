import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_13904_과제 {
	
	static class Assignment implements Comparable<Assignment>{
		int day, weight;

		public Assignment(int day, int weight) {
			this.day = day;
			this.weight = weight;
		}

		@Override
		public int compareTo(Assignment o) {
			if(this.weight == o.weight)
				return this.day - o.day;
			return o.weight - this.weight;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int answer = 0;
		boolean[] submit = new boolean[1001];
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Assignment> pq = new PriorityQueue<>();
		// 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			pq.add(new Assignment(d, w));
		}
		
		while(!pq.isEmpty()) {
			Assignment a = pq.poll();
			for(int i = a.day; i > 0; i--) {
				if(submit[i]) continue;
				submit[i] = true;
				answer += a.weight;
				break;
			}
		}
		
		// 출력
		System.out.println(answer);
	}

}

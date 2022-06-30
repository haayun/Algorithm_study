

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11000_강의실_배정 {

	static class Lecture implements Comparable<Lecture> {
		int s, t;

		Lecture(int s, int t) {
			this.s = s;
			this.t = t;
		}

		@Override
		public int compareTo(Lecture o) {
			if (this.s == o.s)
				return this.t - o.t;
			return this.s - o.s;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Lecture[] lectures = new Lecture[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			lectures[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(lectures);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(lectures[0].t);
		int answer = 1;
		
		for(int i = 1; i < N; i++) {
			if(lectures[i].s >= pq.peek())	// 같은 강의실
				pq.poll();
			else			// 새로운 강의실
				answer++;
			pq.offer(lectures[i].t);
		}
		System.out.println(answer);
	}

}

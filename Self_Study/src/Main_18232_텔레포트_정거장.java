import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18232_텔레포트_정거장 {
	
	static int SIZE = 300001;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int S = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[SIZE];
		for(int i = 0; i < SIZE; i++)
			list[i] = new ArrayList<>();
		int[] time = new int[SIZE];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(S);
		time[S] = 1;
		
		while(!queue.isEmpty()){
			int curr = queue.poll();
			
			if(curr == E) break;
			
			for (int next : list[curr]) {
				if(time[next] == 0) {
					queue.offer(next);
					time[next] = time[curr] + 1;
				}
			}
			
			
			if(curr - 1 > 0 && time[curr - 1] == 0) {
				queue.offer(curr - 1);
				time[curr - 1] = time[curr] + 1;
			}
			
			if(curr + 1 < time.length && time[curr + 1] == 0) {
				queue.offer(curr + 1);
				time[curr + 1] = time[curr] + 1;
			}
		}
		System.out.println(time[E] - 1);
	}

}

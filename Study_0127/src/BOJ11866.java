import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11866 {

	/*
	 * 큐를 원형 큐처럼 사용하기
	 * 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder("<");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 0; i < N; i++)
			queue.add(i+1);
		int cnt = 0;
		while(!queue.isEmpty()) {
			cnt++;
			if(cnt == K) {
				sb.append(queue.poll()).append(", ");
				cnt = 0;
			} else {
				queue.add(queue.poll());
			}
		}
		sb.setLength(sb.length() - 2);
		sb.append('>');
		System.out.println(sb);
	}

}

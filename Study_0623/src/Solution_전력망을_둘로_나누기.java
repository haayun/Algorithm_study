import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_전력망을_둘로_나누기 {

	public static void main(String[] args) {
		System.out.println(solution(9,
				new int[][] { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 } }));
		System.out.println(solution(4, new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 } }));
		System.out.println(solution(7, new int[][] { { 1, 2 }, { 2, 7 }, { 3, 7 }, { 3, 4 }, { 4, 5 }, { 6, 7 } }));
	}

	public static int solution(int n, int[][] wires) {
		int answer = n;

		ArrayList<Integer>[] wireList = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++)
			wireList[i] = new ArrayList<>();

		for (int i = 0; i < wires.length; i++) {
			int v1 = wires[i][0], v2 = wires[i][1];
			wireList[v1].add(v2);
			wireList[v2].add(v1);
		}

		
		for (int i = 0; i < wires.length; i++) {
			int cnt = bfs(n, wireList, wires[i]);
			
			answer = Math.min(answer, Math.abs(n - 2 * cnt));
			if(answer == 0) break;
		}

		return answer;
	}

	public static int bfs(int n, ArrayList<Integer>[] wireList, int[] ignore) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[n + 1];
		
		queue.add(1);
		visited[1] = true;
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			
			int top = queue.poll();
			cnt++;
			
			for (int v : wireList[top]) {
				if(visited[v]) continue;
				if((ignore[0] == top && ignore[1] == v) || (ignore[0] == v && ignore[1] == top)) continue;
				
				queue.offer(v);
				visited[v] = true;
			}
		}
		return cnt;
	}

}

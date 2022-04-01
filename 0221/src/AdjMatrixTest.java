import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
7
8
0 1
0 2	
1 3
1 4
2 4
3 5
4 5
5 6	
*/

public class AdjMatrixTest {

	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 정점 수
		int C = sc.nextInt(); // 간선 수

		int[][] adjMatrix = new int[N][N]; // 정점 수 크기로 생성

		for (int i = 0; i < C; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();

			adjMatrix[to][from] = adjMatrix[from][to] = 1;
		}

//		for (int[] is : adjMatrix) {
//			System.out.println(Arrays.toString(is));
//		}
//		bfs(adjMatrix, 0);
		dfs(adjMatrix, new boolean[N], 0);
		
	}

	public static void bfs(int[][] adjMatrix, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println(current);
			
			for(int j = 0; j<N; j++) {
				if(!visited[j] &&adjMatrix[current][j] != 0) {
					queue.offer(j);
					visited[j] = true;
				}
			}
		}
	}
	
	public static void dfs(int[][] adjMatrix, boolean[] visited, int current) {
		visited[current] = true;
		System.out.println(current);
		
		// current 정점의 인접정점 처리 (단, 방문하지 않은 인접정점만) 
		for(int j = 0; j <N; j++) {
			if(!visited[j] 
					&&adjMatrix[current][j] != 0) {
				dfs(adjMatrix, visited, j);
			}
		}
	}
}

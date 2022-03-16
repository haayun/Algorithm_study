import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1043_거짓말 {
/*
 * 메모리 11784
 * 시간 76
 */
	static int[] parent;
	static boolean[] truth;
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return;
		if(truth[aRoot] || truth[bRoot])
			truth[aRoot]= truth[bRoot] = true;
		if (aRoot < bRoot) {
			parent[aRoot] += parent[bRoot];
			parent[bRoot] = aRoot;
		} else {
			parent[bRoot] += parent[aRoot];
			parent[aRoot] = bRoot;
		}
	}

	static int find(int a) {
		if (parent[a] < 0)
			return a;
		return parent[a] = find(parent[a]);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		Arrays.fill(parent, -1);

		truth = new boolean[N + 1];

		st = new StringTokenizer(br.readLine(), " ");
		int t_num = Integer.parseInt(st.nextToken());
		while(t_num-- > 0) {
			truth[Integer.parseInt(st.nextToken())] = true;
		}
		
		int[] party = new int[M];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int p_num = Integer.parseInt(st.nextToken());
			int first = Integer.parseInt(st.nextToken());
			
			party[i] = first;
			
			while(--p_num > 0) {
				union(first, Integer.parseInt(st.nextToken()));
			}
			
		}
		int ans = 0;
		
		for(int i = 0; i < M; i++) {
			int root = find(party[i]);
			if(!truth[root])
				ans++;
		}
		
		System.out.println(ans);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11724_연결_요소의_개수 {
	
	static int[] parents;
	
	static int findSet(int x) {
        if (parents[x] < 0) return x;
        else return parents[x] = findSet(parents[x]);
    }

	static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return;
		
		if(parents[aRoot] < parents[bRoot]) {
			parents[aRoot] += parents[bRoot];
			parents[bRoot] = aRoot; 
		} else {
			parents[bRoot] += parents[aRoot];
			parents[aRoot] = bRoot;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parents = new int[N+1];
		for(int i = 1; i <= N; i++)
			parents[i] = -1;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			union(u, v);
		}
//		System.out.println(Arrays.toString(parents));
		
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			if(parents[i] < 0)
				ans++;
		}
		System.out.println(ans);
	}
	
}

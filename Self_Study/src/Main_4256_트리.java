

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_4256_트리 {

	static int N;
	static int[] preorder, inorder;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			preorder = new int[N];
			inorder = new int[N];
			int[] postorder = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				preorder[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				inorder[i] = Integer.parseInt(st.nextToken());
			}
			divideConquer(0, 0, N-1);
			System.out.println();
		}
	}
	
	
	static void divideConquer(int idx, int left, int right) {
		if(left > right) return;
		
		int root = preorder[idx];
		int in_idx = 0;
		for(int i = 0; i < N; i++) {
			if(inorder[i] == root) in_idx = i;
		}
		
		divideConquer(idx + 1, left, in_idx - 1);
		divideConquer(idx + (in_idx - left) + 1, in_idx + 1, right);
		System.out.print(root + " ");
		
	}
	
}

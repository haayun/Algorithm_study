import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18233_러버덕을_사랑하는_모임 {

	static int N, P, E;
	static int[] input[], p;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		input = new int[N][];
		p = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			input[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		}

		int cnt = 0;
		while (++cnt <= P)
			p[N - cnt] = 1;
		
		int[] index = new int[P];
		int min, max;
		boolean flag = false;
		do {
			cnt = 0;
			min = 0;
			max = 0;
			for (int i = 0; i < N; i++) {
				if (p[i] == 1) {
					min += input[i][0];
					max += input[i][1];
					index[cnt++] = i;
				}
			}
			if (min <= E && E <= max) {
				flag = true;
				break;
			}
		} while (np());

		if(!flag) {
			System.out.println("-1");
			return;
		}
		
		int ans[] = new int[N];
		E -= min;
		
		
		for(int i =0; i < P; i++) {
			ans[index[i]] = input[index[i]][0];
				
			int temp = input[index[i]][1] - input[index[i]][0];
			
			if(temp >= E) {
				ans[index[i]] += E;
				E = 0;
			} else {
				ans[index[i]] += temp;
				E -= temp;
			}
		}
		
		for(int i = 0; i < N; i++) {
			System.out.print(ans[i] + " ");
		}
	}

	static boolean np() {
		int i = N - 1;
		while (i > 0 && p[i - 1] >= p[i])
			--i;

		if (i == 0)
			return false;

		int j = N - 1;
		while (p[i - 1] >= p[j])
			--j;

		swap(i - 1, j);

		int k = N - 1;
		while (i > k)
			swap(i++, k--);

		return true;
	}

	static void swap(int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}
}

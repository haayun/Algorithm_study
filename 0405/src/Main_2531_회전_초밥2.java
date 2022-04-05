import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2531_회전_초밥2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] belt = new int[N];
		int[] sushi = new int[d + 1];
		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
			if (i < k) sushi[belt[i]]++;
		}
		sushi[c]++;

		int answer = countKinds(sushi);
		int left = 0, right = k - 1;
		while (left < N) {

			sushi[belt[left++]]--;
			right = (right + 1) % N;
			sushi[belt[right]]++;
			int kinds = countKinds(sushi);

			answer = Math.max(answer, kinds);
		}
		System.out.println(answer);
	}

	static int countKinds(int[] sushi) {
		int res = 0;
		for (int i = 0; i < sushi.length; i++) {
			if (sushi[i] > 0)
				res++;
		}
		return res;
	}

}

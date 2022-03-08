import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9019_DSLR {

	static class register {
		int value;
		String s;

		register(int value, String s) {
			this.value = value;
			this.s = s;
		}

		int d() {
			return (value * 2) % 10000;
		}

		int s() {
			return value != 0 ? value - 1 : 9999;
		}

		int l() {
			return value % 1000 * 10 + value / 1000;
		}

		int r() {
			return value % 10 * 1000 + value / 10;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			Queue<register> queue = new LinkedList<>();
			boolean[] visited = new boolean[10000];

			queue.offer(new register(A, ""));

			while (!queue.isEmpty()) {

				register current = queue.poll();

				if (current.value == B) {
					System.out.println(current.s);
					break;
				}

				int d = current.d();
				if (!visited[d]) {
					visited[d] = true;
					queue.offer(new register(d, current.s + "D"));
				}

				int s = current.s();
				if (!visited[s]) {
					visited[s] = true;
					queue.offer(new register(s, current.s + "S"));
				}

				int l = current.l();
				if (!visited[l]) {
					visited[l] = true;
					queue.offer(new register(l, current.s + "L"));
				}

				int r = current.r();
				if (!visited[r]) {
					visited[r] = true;
					queue.offer(new register(r, current.s + "R"));
				}

			}
		}
	}

}

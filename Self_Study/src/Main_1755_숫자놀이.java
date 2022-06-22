
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1755_숫자놀이 {
	public static void main(String[] args) throws IOException {
		String[] eng = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine()); 
		int m = Integer.parseInt(st.nextToken()); 
		int n = Integer.parseInt(st.nextToken()); 
		PriorityQueue<Number> pq = new PriorityQueue<>();
		for (int i = m; i <= n; i++) {
			String s = "";
			if (i < 10) { 
				s = eng[i];
			} else {
				s += eng[i / 10];
				s += " "; 
				s += eng[i % 10];
			}
			pq.add(new Number(s, i)); 
		}
		int cnt = 0;
		while (!pq.isEmpty()) { 
			Number c = pq.poll(); 
			cnt++; 
			sb.append(c.n).append(" ");
			if (cnt % 10 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb); 
	}
}

class Number implements Comparable<Number> { 
	String s;
	int n;

	public Number(String s, int n) {
		super();
		this.s = s;
		this.n = n;
	}

	@Override
	public int compareTo(Number o) { 
		return s.compareTo(o.s);
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_17413_단어_뒤집기_2 {

	static StringBuilder sb = new StringBuilder();
	static Stack<Character> stack = new Stack<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		boolean inTag = false;
		for(int i = 0; i < S.length(); i++) {
			Character cur = S.charAt(i);
			if(cur == '<') {
				reverse();
				inTag = true;
				sb.append(cur);
			} else if (inTag) {
				sb.append(cur);
				if(cur == '>') inTag = false;
			} else if (cur == ' '){
				reverse();
				sb.append(cur);
			} else {
				stack.add(cur);
			}
		}
		reverse();
		System.out.println(sb.toString());
	}
	
	static void reverse() {
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
	}
}

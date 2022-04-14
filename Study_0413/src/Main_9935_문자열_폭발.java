import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9935_문자열_폭발 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		String origin = br.readLine();
		String explode = br.readLine();
		
		int el = explode.length();
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < origin.length(); i++) {
			stack.push(origin.charAt(i));
			
			if(stack.size() >= el) {
				boolean flag = true;
				// stack에 최근에 쌓인 문자들이 폭발 문자열인지 확인
				for(int j = 0; j < el; j++) {
					if(stack.get(stack.size() - el + j) != explode.charAt(j)) {
						flag = false;
						break;
					}
				}
				// 폭발 문자열이었다면 스택에서 제거
				if(flag) {
					for(int j = 0; j < el; j++)
						stack.pop();
				}
			}
		}
		for (Character c : stack) {
			sb.append(c);
		}
		// 출력
		System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
	}

}

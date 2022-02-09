import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			Stack<Character> stack = new Stack<Character>();
			String data = br.readLine();
			
			boolean finish = false;
			for(int i = 0; i < data.length(); i++) {
				char c = data.charAt(i);
				if(c == '(') {
					stack.push(c);
				} else {
					if(stack.empty()) {
						finish = true;
						break;
					} else {
						stack.pop();
					}
				}
			}
			
			if(!stack.empty() || finish)
				System.out.println("NO");
			else
				System.out.println("YES");
		}
	}

}

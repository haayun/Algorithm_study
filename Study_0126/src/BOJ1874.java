import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BOJ1874 {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		List<Integer> target = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		int index = 0, num = 1;
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			target.add(Integer.parseInt(br.readLine()));
		}
		for(int i = 0; i < N; i++) {
			
		}
		
		
		while(index <= N - 1) {
			//스택이 비어있거나 스택의 peek값이 현재 출력해야되는 target보다 작다면
			if(stack.isEmpty() || stack.peek() < target.get(index)) {
				stack.push(num++);
				sb.append('+').append('\n');
			}
			// 스택의 peek값이랑 현재 target 값이 동일하다면 
			else if(stack.peek() == target.get(index)){
				index++;
				stack.pop();
				sb.append('-').append('\n');
			}
		}
		System.out.println(sb);
	}

}

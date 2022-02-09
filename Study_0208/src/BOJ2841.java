import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2841 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), P = Integer.parseInt(st.nextToken());
		Stack<Integer>[] stack = new Stack[7];
		int ans = 0;
		
		while(N-- > 0) {
			//입력
			st = new StringTokenizer(br.readLine(), " ");
			int string = Integer.parseInt(st.nextToken()), fret = Integer.parseInt(st.nextToken());
			
			//현재 줄의 stack이 없다면 생성
			if(stack[string] == null) 
				stack[string] = new Stack<>();
			
			if(stack[string].isEmpty()) {
				stack[string].push(fret);
				ans++;
			} else if (stack[string].peek() == fret) {	// 누르려는 프렛이 이미 stack의 top이면 넘어감
				continue;
			} else if (stack[string].peek() > fret) {	// 더 높은 음이 눌려있으면 손을 떼야함
				while(!stack[string].isEmpty() && stack[string].peek() > fret) {
					stack[string].pop();
					ans++;
				}
			} 
			if(stack[string].isEmpty() || stack[string].peek() != fret) {
				stack[string].push(fret);
				ans++;
			}
		}
		
		//출력
		System.out.println(ans);
	}

}

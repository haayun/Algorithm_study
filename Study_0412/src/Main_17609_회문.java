import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17609_회문 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			String s = br.readLine();
			int left = 0, right = s.length() - 1;
			int answer = 0;
			while(left < right) {
				if(s.charAt(left) == s.charAt(right)) {
					left++;
					right--;
				} else {
					if(palindrome(s.substring(left + 1, right + 1))) {
						answer = 1;
						break;
					} else if (palindrome(s.substring(left, right))) {
						answer = 1;
						break;
					} else {
						answer = 2;
						break;
					}
				}
			}
			System.out.println(answer);
		}
	}

	static boolean palindrome(String s) {
		int left = 0, right = s.length() - 1;
		while(left < right) {
			if(s.charAt(left) == s.charAt(right)) {
				left++;
				right--;
			}
			else return false;
		}
		return true;
	}
	
}

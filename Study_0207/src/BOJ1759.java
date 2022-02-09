import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
	
	static int L, C;
	static char alphabet[], password[];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		
		alphabet = new char[C];
		password = new char[L];
		
		for (int i = 0; i < C; i++) 
			alphabet[i] = st.nextToken().charAt(0);
		
		Arrays.sort(alphabet);
		combination(0, 0);
	}
	
	static void combination(int cnt, int start) {
		if(cnt == L) {
			if(check(password)) {
				for(int i = 0; i < L; i++)
					System.out.print(password[i]);
				System.out.println();
			}
			return;
		}
		
		for (int i = start; i < C; i++) {
			password[cnt] = alphabet[i];
			combination(cnt + 1, i + 1);
		}
	}
	
	static boolean check(char[] s) {
		int vow = 0, con = 0;
		for (int i = 0; i < s.length; i++) {
			switch (s[i]) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				vow++;
				break;
			default:
				con++;
				break;
			}
		}
		if(vow >= 1 && con >= 2)
			return true;
		return false;
	}

}

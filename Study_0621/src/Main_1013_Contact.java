import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main_1013_Contact {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String regExp = "(100+1+|01)+";
		while (T-- > 0) {
			String wave = br.readLine();
			
			boolean result = Pattern.matches(regExp, wave);
			
			if(result) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
	
}

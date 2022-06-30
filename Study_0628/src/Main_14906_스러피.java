import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main_14906_스러피 {

	static String Slump;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Slump = "((D|E)F+)+G";

		System.out.println("SLURPYS OUTPUT");
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			int idx = 0;
			for (idx = s.length() - 1; idx >= 0; idx--) {
				if (s.charAt(idx) == 'C')
					break;
			}

			if(!s.contains("C")) idx = 1;
			
			boolean answer = false;
			boolean isSlimp = isSlimp(s.substring(0, idx + 1));
			boolean isSlump = Pattern.matches(Slump, s.substring(idx + 1, s.length()));
			if (isSlump && isSlimp)
				answer = true;

			System.out.println(answer ? "YES" : "NO");

		}
		System.out.println("END OF OUTPUT");
	}

	static boolean isSlimp(String s) {
		if(s.length() < 2) return false;
		
		else if (s.length() == 2 && s.equals("AH"))
			return true;

		else if (s.substring(0, 2).equals("AB") && s.charAt(s.length() - 1) == 'C') {
			return isSlimp(s.substring(2, s.length() - 1));
		}

		else if (s.charAt(0) == 'A' && s.charAt(s.length() - 1) == 'C') {
			return Pattern.matches(Slump, s.substring(1, s.length() - 1));
		}

		return false;

	}
}

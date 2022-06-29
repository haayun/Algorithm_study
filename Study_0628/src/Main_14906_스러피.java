import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main_14906_스러피 {

	static String Slump;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Slump = "((D|E)F+)+G";
		
		
		System.out.println(Pattern.matches(Slump, "DFFEFFFG"));
		
		
		
		sb.append("SLURPYS OUTPUT");
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			int i = 0;
			for(i =0; i < s.length(); i++) {
				if(s.charAt(i) == 'G') break;
			}
			
		}
		sb.append("END OF OUTPUT");
	}
	
	static boolean isSlimp(String s) {
		
		if(s.length() == 2 && s.equals("AH")) return true;
		
		else if(s.substring(0, 2).equals("AB") && s.charAt(s.length()-1) == 'C') {
			return isSlimp(s.substring(2, s.length() - 1));
		}
		
		else if(s.charAt(0) == 'A' && s.charAt(s.length() - 1) == 'C') {
			return Pattern.matches(Slump, s.substring(1, s.length() - 1));
		}
		
		return false;
		
	}
}

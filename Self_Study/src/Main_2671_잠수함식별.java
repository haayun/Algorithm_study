

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main_2671_잠수함식별 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		String reg = "(100+1+|01)+";
		
		boolean res = Pattern.matches(reg, s);
		if(res)
			System.out.println("SUBMARINE");
		else
			System.out.println("NOISE");
	}

}

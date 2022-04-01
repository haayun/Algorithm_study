package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12927_배수_스위치 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = br.readLine().toCharArray();
		char[] target = new char[arr.length];
		Arrays.fill(target, 'N');
		
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target[i])
				continue;
			cnt++;
			for (int j = i; j < arr.length; j += (i+1)) {
				if(arr[j] == 'Y')
					arr[j] = 'N';
				else
					arr[j] = 'Y';
			}
		}
		System.out.println(cnt);

	}

}

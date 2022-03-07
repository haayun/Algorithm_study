import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1339_단어_수학 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char[][] words = new char[N][];
		int[] alphabet = new int[27];
		int temp;
		for(int i = 0; i < N; i++) {
			words[i] = br.readLine().toCharArray();
			for(int j = 0; j < words[i].length; j++) {
				temp = 1;
				for(int k = j + 1; k < words[i].length; k++)
					temp *= 10;
				alphabet[words[i][j] - 'A'] += temp;
			
			}
		}
		
		
		Arrays.sort(alphabet);
		
		int ans = 0;
		int num = 9;
		int index = 26;
		
		while(alphabet[index] > 0) {
			ans += alphabet[index] * num;
			num--;
			index--;
		}
		System.out.println(ans);
	}

}

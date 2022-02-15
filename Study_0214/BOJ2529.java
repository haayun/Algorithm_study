import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2529 {
	static char[] signs;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = 10;
		signs = new char[k];
		ArrayList<int[]> ans = new ArrayList<>();
		for(int i = 0; i <k; i++)
			signs[i] = st.nextToken().charAt(0);
		
		
		int[] input_max = new int[k+1], input_min = new int[k+1];
		
		for(int i = 0; i < k+1; i++) {
			input_min[i] = i;
			input_max[i] = N - k - 1 +  i;
		}
		
		// 최대 정수 구하기   
		do {
			if(checkSign(input_max)) {
//				System.out.println(Arrays.toString(input_max));
				ans.add(input_max);
				break;
			}
		} while(pp(input_max));
		
		
		// 최소 정수 구하기    
		do {
			if(checkSign(input_min)) {
				ans.add(input_min);
				break;	// 가장 처음 만든 순열이 최소  
			}
		} while(np(input_min));
	
//		for(int i = 0; i < ans.size(); i++) {
//			System.out.println(Arrays.toString(ans.get(i)));
//		}
		
		
		for(int i = 0; i < ans.size(); i++) {
//			System.out.println(Arrays.toString(ans.get(i)));
			for(int j = 0; j<k+1; j++)
				sb.append(ans.get(i)[j]);
			sb.append('\n');
		}
		System.out.println(sb);
		
		
	}

	static boolean checkSign(int[] input) {
		int before = input[0];
		for (int i = 0; i < signs.length; i++) {
			if ((signs[i] == '<' && (before > input[i + 1])))
				return false;
			if ((signs[i] == '>' && (before < input[i + 1])))
				return false;
			before = input[i + 1];
		}
		return true;
	}
	static boolean pp(int[] input) {
		int n = input.length;
		int i = n -1;
		while(i > 0 && input[i-1] <= input[i]) {
			--i;
		}
		if(i == 0) return false;
	
		int j = n-1;
		while(input[j] >= input[i-1])
			--j;
		
		swap(input, i-1, j);
		
		int k = n-1;
		while(i < k)
			swap(input, i++, k--);
		return true;
		
	}
	static boolean np(int[] input) {
		int n = input.length;
		int i = n - 1;
		while (i > 0 && input[i - 1] >= input[i])
			--i;
		if (i == 0)
			return false;

		int j = n - 1;
		while (input[i - 1] >= input[j])
			--j;

		swap(input, i - 1, j);

		int k = n - 1;
		while (i < k)
			swap(input, i++, k--);

		return true;
	}

	static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

}

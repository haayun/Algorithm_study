import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_18870_좌표_압축 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		int[] result = new int[N];
		st = new StringTokenizer(br.readLine(), " "); 
		// 인덱스와 입력 수 이차원 배열로 저장 
		for (int i = 0; i < N; i++) {
			arr[i] = new int[] { i, Integer.parseInt(st.nextToken()) };
		}
		
		// 입력받은 수로 정렬 
		Arrays.sort(arr, (o1, o2) -> o1[1] - o2[1]);
	 
		// 중복 수가 나올 수 있으므로 검사하여 result 배열에 바로 저장 
		for (int i = 1; i < N; i++) {
			if (arr[i-1][1] == arr[i][1]) {
				result[arr[i][0]]  = result[arr[i-1][0]];
			} else {
				result[arr[i][0]]  = result[arr[i-1][0]] + 1;
			}
		}
		for (int i = 0; i < N; i++) { 
			bw.write(result[i] + " ");
		}
		bw.flush();
	}

}

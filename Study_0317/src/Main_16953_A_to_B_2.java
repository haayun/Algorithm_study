import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16953_A_to_B_2 {
	/*
	 * 그리디
	 * 메모리 11516
	 * 시간 84
	 */

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int cnt = 1;
		while(B > A) {
			if(B % 2 == 0 && B / 2 >= A) {
				B /= 2;
			}
			else if(B % 10 == 1 && B / 10 >= A) {
				B /= 10;
			}
			else {
				cnt = -1;
				break;
			}
			cnt++;
		}
		
		System.out.println(cnt);
	}

}

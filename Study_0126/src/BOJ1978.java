import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1978 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		// 에라토스테네스의 체
		boolean[] isPrime = new boolean[1001];
		for(int i = 0; i < isPrime.length; i++)
			isPrime[i] = true;				// 모두 소수로 초기화
		isPrime[0] = isPrime[1] = false;	// 0과 1은 소수가 아님
		for(int i = 2; i*i <= 1000; i++) {	
			if(isPrime[i]) {	
				for(int j = i*i; j <= 1000; j += i)	// i의 배수들 다 지우기
					isPrime[j] = false;
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0, num;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			if(isPrime[num])
				count++;
		}
		
		System.out.println(count);
	}

}

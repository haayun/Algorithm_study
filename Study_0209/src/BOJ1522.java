import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1522 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		char[] chars = br.readLine().toCharArray();
		int cntA = 0, len = chars.length;
		for(int i = 0; i < len; i++) 
			if(chars[i] == 'a') cntA++;
		
		int ans = len;	// 최대값으로 초기화
		for(int i = 0; i < len; i++) {
			int cntB = 0;
			for(int j = 0; j < cntA; j++) {	
				int index = (i + j) % len;
				if(chars[index] == 'b') cntB++;	// b라면 교환
			}
			if(ans > cntB) ans = cntB;
		}
		
		// 출력
		System.out.println(ans);
	}

}

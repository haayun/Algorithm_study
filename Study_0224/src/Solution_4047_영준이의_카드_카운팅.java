import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4047_영준이의_카드_카운팅 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		char[] temp;
		boolean[][] card;
		int[] ans;
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			temp = br.readLine().toCharArray();
			card = new boolean[4][14];
			ans = new int[4];
			Arrays.fill(ans, 13);
			
			boolean flag = true;
			
			for(int i = 0; i < temp.length; i += 3){
				int p = getPattern(temp[i]);
				int n = getNumber(temp[i+1], temp[i+2]);
				if(card[p][n]) {
					flag = false;
					break;
				}
				else {
					card[p][n] = true;
					ans[p]--;
				}
			}
			
			if(!flag) {
				sb.append("ERROR\n");
				continue;
			}
			for(int i = 0; i < 4; i++)
				sb.append(ans[i]).append(" ");
			sb.append("\n");
			
		}
		System.out.println(sb);
	
	}
	
	static int getPattern(char c) {
		if(c == 'S')
			return 0;
		else if (c == 'D')
			return 1;
		else if (c == 'H')
			return 2;
		else
			return 3;
	}

	static int getNumber(char c1, char c2) {
		if(c1 == '0')
			return c2 - '0';
		else 
			return c2 - '0' + 10;
	}
}

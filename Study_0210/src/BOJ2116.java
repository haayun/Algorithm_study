import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2116 {
	static int num, max;
	static int[][] dices;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		num = Integer.parseInt(br.readLine());
		dices = new int[num][6];
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// A B C E D F 순으로 저장 (0 - 5, 1 - 4, 2 - 3)
			dices[i][0] = Integer.parseInt(st.nextToken());
			dices[i][1] = Integer.parseInt(st.nextToken());
			dices[i][2] = Integer.parseInt(st.nextToken());
			dices[i][4] = Integer.parseInt(st.nextToken());
			dices[i][3] = Integer.parseInt(st.nextToken());
			dices[i][5] = Integer.parseInt(st.nextToken());
		}
		
		max = 0;
		for (int i = 0; i < 6; i++) 
			getMax(0, dices[0][i], 0);
		
		System.out.println(max);
	}

	static void getMax(int cnt, int prev_top, int sum) {
		if (cnt == num) {
			max = Math.max(max, sum);
			return;
		}
		int top = 0, side = 0;
		for (int i = 0; i < 6; i++) {
			if (dices[cnt][i] == prev_top) {
				top = 5 - i;
				break;
			}
		}
		
		if (Math.max(prev_top, dices[cnt][top]) != 6)
			side = 6;
		else if (Math.min(prev_top, dices[cnt][top]) != 5)
			side = 5;
		else
			side = 4;
		
		getMax(cnt + 1, dices[cnt][top], sum + side);
	}

}

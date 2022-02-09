import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ10989 {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] list = new int[10001];
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++)
			list[Integer.parseInt(br.readLine())]++;
		
		for(int i = 0; i < 10001; i++) {
			if(list[i] > 0) {
				list[i]--;
				sb.append(i).append('\n');
				if(list[i] > 0)
					i--;
			}
		}
		System.out.println(sb);
	}

}

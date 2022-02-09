import java.util.*;

public class BOJ1654 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int N = sc.nextInt();
		int[] lan = new int[K];
		int cut = Integer.MAX_VALUE;
		for(int i = 0; i < K; i++) {
			lan[i] = sc.nextInt();
			if(lan[i] < cut)
				cut = lan[i];
		}
		
		for(; ; cut--) {
			int count = 0;
			for(int i = 0; i < K; i++) {
				count += lan[i]/cut;
			}
			if(count >= N)
				break;
		}
		
		System.out.println(cut);
	}

}

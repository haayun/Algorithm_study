import java.util.*;

public class BOJ10773 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		int[] nums = new int[K];
		int index = 0;
		for(int i = 0; i < K; i++) {
			int num = sc.nextInt();
			nums[index] = num;
			index++;
			if(num == 0) {
				index -= 2;
			}
			
		}
		int sum = 0;
		for(int j = 0; j < index; j++)
			sum += nums[j];
		System.out.println(sum);
	}

}

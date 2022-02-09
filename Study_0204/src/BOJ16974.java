import java.util.Scanner;

public class BOJ16974 {
	static StringBuilder sb = new StringBuilder();
	static String basicBurger = "BPPPB";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
//		String burger = makeBurger(N);
		
		
		
	}
	static int countLayer(int n) {
		if(n == 1) return 5;
		return 3 + 2 * countLayer(n-1);
	}
	
	static String makeBurger(int n) {
		if(n == 1) return basicBurger;
		String temp = makeBurger(n-1);
		return sb.append("B").append(temp).append("P")
				.append(temp).append("B").toString();
	}
}

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_수식_최대화2 {
// https://programmers.co.kr/learn/courses/30/lessons/67257
	public static void main(String[] args) {
//		System.out.println(solution("100-200*300-500+20"));
//		System.out.println(solution("2*2*2*2*2-2*2*2"));
		System.out.println(solution("200-300-500-600*40+500+500"));
//		System.out.println(solution("177-661*999*99-133+221+334+555-166-144-551-166*166-166*166-133*88*55-11*4+55*888*454*12+11-66+444*99"));
	}

	static int[] p = new int[] { 0, 1, 2 };
	static char[] op = new char[] { '+', '-', '*' };

	public static long solution(String expression) {
		long answer = 0;
		ArrayList<Long> nums = new ArrayList<>();
		ArrayList<Character> ops = new ArrayList<>();

		long temp = 0;
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
				temp = temp * 10 + Long.parseLong(expression.substring(i, i + 1));
			} else {
				ops.add(expression.charAt(i));
				if (temp != 0) {
					nums.add(temp);
					temp = 0;
				}
			}
		}
		nums.add(temp);
		
		
		do {
			ArrayList<Long> copy_nums = new ArrayList<>(nums);
			ArrayList<Character> copy_ops = new ArrayList<>(ops);

			for (int i = 0; i < p.length; i++) {
				for (int j = 0; j < copy_ops.size(); j++) {
					char operator = copy_ops.get(j);
					if (operator == op[p[i]]) {
						long operand1 = copy_nums.get(j);
						long operand2 = copy_nums.get(j + 1);
						copy_nums.remove(j);

						if (operator == '+') {
							copy_nums.set(j, operand1 + operand2);
						} else if (operator == '-') {
							copy_nums.set(j, operand1 - operand2);
						} else {
							copy_nums.set(j, operand1 * operand2);
						}

						copy_ops.remove(j);
						j--;
					}
				}
			}

			answer = Math.max(answer, Math.abs(copy_nums.get(0)));
			System.out.println(Arrays.toString(p));
			System.out.println(copy_nums.get(0));
		} while (np());

		return answer;
	}

	static boolean np() {
		int i = 2;
		while (i > 0 && p[i - 1] >= p[i])
			--i;

		if (i == 0)
			return false;

		int j = 2;
		while (p[i - 1] >= p[j])
			--j;

		swap(i - 1, j);

		int k = 2;
		while (i < k)
			swap(i++, k--);

		return true;
	}

	static void swap(int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}

}

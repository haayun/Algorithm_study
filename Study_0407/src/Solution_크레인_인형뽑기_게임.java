import java.util.Stack;

public class Solution_크레인_인형뽑기_게임 {
// https://programmers.co.kr/learn/courses/30/lessons/64061
	public static void main(String[] args) {
		int[][] board = { { 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 2, 1, 0, 0 }, { 0, 2, 1, 0, 0 },
				{ 0, 2, 1, 0, 0 } };
		int[] moves = { 1, 2, 3, 3, 2, 3, 1 };

		System.out.println(solution(board, moves));
	}

	static int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		for (int m = 0; m < moves.length; m++) {
			// 뽑기
			int doll = 0;
			for (int i = 0; i < board.length; i++) {
				int c = moves[m] - 1;
				if (board[i][c] == 0) continue;
				doll = board[i][c];
				board[i][c] = 0;
				break;
			}

			// 바구니에 넣기
			if (!stack.isEmpty() && stack.peek() == doll) {
				answer += 2;
				stack.pop();
			} else if (doll > 0) {
				stack.push(doll);
			}
		}

		return answer;
	}
}

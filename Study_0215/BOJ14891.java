import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ14891 {
	static ArrayList<Integer>[] gears;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		gears = new ArrayList[5];

		// 입력
		for (int i = 1; i < 5; i++) {
			char[] temp = br.readLine().toCharArray();
			gears[i] = new ArrayList<Integer>();
			for (int j = 0; j < 8; j++) {
				gears[i].add(temp[j] - '0');
			}
		}

		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken()), dir = Integer.parseInt(st.nextToken());

			int left = gears[num].get(6), right = gears[num].get(2), dir_save = dir;

			// 왼쪽 톱니바퀴 회전하기
			for (int j = num - 1; j > 0; j--) {
				if (left != gears[j].get(2)) {
					left = gears[j].get(6);
					rotate(j, dir *= (-1));
				} else {
					break;
				}
			}
			// 오른쪽 톱니바퀴 회전하기
			dir = dir_save;
			for (int j = num + 1; j < 5; j++) {
				if (right != gears[j].get(6)) {
					right = gears[j].get(2);
					rotate(j, dir *= (-1));
				} else {
					break;
				}
			}

			rotate(num, dir_save);

		}

		// 출력
		int ans = 0;
		for (int i = 1; i < 5; i++) {
			ans += gears[i].get(0) * (1 << (i - 1));
		}
		System.out.println(ans);
	}

	// 반시계, 시계 방향으로 회전
	static void rotate(int num, int dir) {
		if (dir == -1) {
			int temp = gears[num].remove(0);
			gears[num].add(temp);

		} else {
			int temp = gears[num].remove(7);
			gears[num].add(0, temp);
		}

	}

}

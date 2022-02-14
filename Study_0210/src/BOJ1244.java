import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1244 {
	static int N, M;
	static int[][] students;
	static boolean[] lights;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		lights = new boolean[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		//입력
		for (int i = 1; i <= N; i++) {
			lights[i] = (st.nextToken().equals("1") ? true : false);
		}
		M = Integer.parseInt(br.readLine());
		students = new int[M][2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			students[i][0] = Integer.parseInt(st.nextToken());
			students[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//연산
		for(int i = 0; i < M; i++) {
			if(students[i][0] == 1) {
				male(students[i][1]);
			} else {
				female(students[i][1]);
			}
		}
		
		//출력
		for(int i = 1; i <= N; i++) {
			System.out.print(lights[i] ? "1 " : "0 ");
			if(i % 20 == 0)
				System.out.println();
		}
		

	}
	
	static void male(int num) {
		for(int i = num; i <= N; i += num) 
			lights[i] = !lights[i];
	}
	
	static void female(int num) {
		lights[num] = !lights[num];
		for(int i = 1; ; i++) {
			if(num - i >= 1 && num + i <= N && lights[num - i] == lights[num + i]) {
				lights[num - i] = !lights[num - i];
				lights[num + i] = !lights[num + i];
			} else {
				break;
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20055_컨베이어_벨트_위의_로봇 {
	
	static class space{
		int power;
		boolean robot_on;
		
		public space(int power, boolean robot_on) {
			this.power = power;
			this.robot_on = robot_on;
		}
		
		
	}

	static int N, K, no_power = 0;
	static space[] belt;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		belt = new space[2 * N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 2 * N; i++) {
			belt[i] = new space(Integer.parseInt(st.nextToken()), false);
		}
		
		int start = 0;
		int end = N - 1;
		int cnt = 0;
		
		while(true) {
			start = changePos(start);
			end = changePos(end);
			// 로봇 내리기 
			if(belt[end].robot_on)
				belt[end].robot_on = false;
			// 로봇 옮기기 
			moveRobot(start, end);
			// 로봇 올리기
			if(belt[start].power > 0) {
				belt[start].robot_on = true;
				belt[start].power--;
				if(belt[start].power == 0)
					no_power++;
			}
			
			cnt++;
			if(no_power >= K)
				break;
			
		}
		
		System.out.println(cnt);
	}
	
	static int changePos(int pos) {
		if(--pos >= 0)
			return pos;
		return 2 * N - 1;
	}
	
	static void moveRobot(int start, int end) {
		int curr = end;
		
		while(curr != start) {
			curr = changePos(curr);
			int next = (curr + 1) % (2 * N);
			if(belt[curr].robot_on && !belt[next].robot_on && belt[next].power > 0) {
				belt[curr].robot_on = false;
				belt[next].power--;
				if(next != end)
					belt[next].robot_on = true;
				if(belt[next].power == 0)
					no_power++;
					
			}
		}
	}
	
	
}

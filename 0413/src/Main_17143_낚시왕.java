import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_17143_낚시왕 {

	static class Shark {
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static int R, C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
//		Shark[] sharks = new Shark[M];
		ArrayList<Shark> sharks = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
//			sharks[i] = new Shark(r, c, s, d, z);
			sharks.add(new Shark(r, c, s, d, z));
		}
		
		int man = 0;
		int answer = 0;
		while(man <= C) {
			// 1. 낚시꾼 오른쪽으로 한 칸 이동
			man++;
			
			// 2. 가까운 상어 잡기
			int minR = R + 1;
			Shark tmp = null;
			for (Shark shark : sharks) {
				if(shark.c != man) continue;
				if(shark.r < minR) {
					minR = shark.r;
					tmp = shark;
				}
			}
			if(minR != R + 1) {
				answer += tmp.z;
				sharks.remove(tmp);
			}
			
			// 3. 이동하기
			ArrayList<Shark> after = new ArrayList<>();
			for (Shark shark : sharks) {
				after.add(moveShark(shark));
			}
			
			Collections.sort(after, (e1, e2) -> e2.z - e1.z);
			
			sharks.clear();
			outer : for(int i = 0; i < after.size(); i++) {
				for(int j = 0; j < sharks.size(); j++) {
					if(sharks.get(j).r == after.get(i).r && sharks.get(j).c == after.get(i).c)
						continue outer;
				}
				sharks.add(after.get(i));
			}
			
		}
		System.out.println(answer);
	}
	static Shark moveShark(Shark shark) {
		int r = shark.r;
		int c = shark.c;
		int s = shark.s;
		int d = shark.d;
		int z = shark.z;
		
		if(d < 2) s %= (R - 1) * 2;
		else s %= (C - 1) * 2;
		
		for(int i = 0; i < s; i++) {
			r += dr[d];
			c += dc[d];
			if (r <= 0 || r > R) {
				r -= dr[d];
				d = (d + 1) % 2;
				r += dr[d];
			}
			if (c <= 0 || c > C) {
				c -= dc[d];
				d = 2 + (d + 1) % 2;
				c += dc[d];
			}
		}
//		System.out.println(r + " " + c);
		return new Shark(r, c, s, d, z);
	}

}

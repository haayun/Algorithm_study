import java.io.*;
import java.util.*;

public class BOJ10814 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		
		/**
		 * 방법 1 : String[][] 
		 */
//		String[][] members = new String[N][2];
//		for(int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine()," ");
//			members[i][0] = st.nextToken();
//			members[i][1] = st.nextToken();
//		}
//		
//		Arrays.sort(members, new Comparator<String[]>() {
//
//			@Override
//			public int compare(String[] o1, String[] o2) {
//				// TODO Auto-generated method stub
//					return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
//			}
//			
//		});
		
		/**
		 * 방법 2 : List<String>
		 */
//		List<String> members = new ArrayList<String>();
//		for (int i = 0; i < N; i++) {
//			members.add(br.readLine());
//		}
//		
//		Collections.sort(members, new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				// TODO Auto-generated method stub
//				int n1 = Integer.parseInt(new StringTokenizer(o1," ").nextToken());
//				int n2 = Integer.parseInt(new StringTokenizer(o2," ").nextToken());
//				return n1 - n2;
//			}
//			
//		});
//		
//		for (String member : members) {
//			sb.append(member).append("\n");
//		}
//		System.out.println(sb);
		
		
		/**
		 * 방법 3 : StringBuilder[]
		 * 참고 : https://st-lab.tistory.com/113
		 */
		StringBuilder[] members = new StringBuilder[201];
		for(int i = 0; i < members.length; i++) {
			members[i] = new StringBuilder();
		}
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			members[age].append(age).append(" ").append(name).append("\n");
		}
		for (StringBuilder member : members) {
			sb.append(member);
		}
		System.out.println(sb);
	}

}

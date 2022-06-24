
public class Solution_최소직사각형 {


	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } }));
		System.out.println(solution(new int[][] { { 10, 7 }, { 12, 3 }, { 8, 15 }, { 14, 7 }, { 5, 15 } }));
		System.out.println(solution(new int[][] { { 14, 4 }, { 19, 6 }, { 6, 16 }, { 18, 7 }, { 7, 11 } }));
	}

	public static int solution(int[][] sizes) {

        int w = 0, h = 0;
        
        for(int i = 0; i < sizes.length; i++){
            int cw = Math.max(sizes[i][0], sizes[i][1]);
            int ch = Math.min(sizes[i][0], sizes[i][1]);
            
            w = Math.max(w, cw);
            h = Math.max(h, ch);
        }
		return w * h;
	}

}

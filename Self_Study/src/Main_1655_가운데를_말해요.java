import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_1655_가운데를_말해요 {
/*
 * https://www.acmicpc.net/board/view/66892
 */
	static PriorityQueue<Integer> min_heap, max_heap;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		min_heap = new PriorityQueue<Integer>();
		max_heap = new PriorityQueue<Integer>(Comparator.reverseOrder());
		
		int N = Integer.parseInt(br.readLine());
		
		while(N-- > 0) {
			int num = Integer.parseInt(br.readLine());
			
			if(max_heap.size() == 0) {
				max_heap.offer(num);
			}
			if(max_heap.size() > min_heap.size()) {
				
			} else if (max_heap.size() < min_heap.size()) {
				
			} else {
				
			}
		}
	}

}

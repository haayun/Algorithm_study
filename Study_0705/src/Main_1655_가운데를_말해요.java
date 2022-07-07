import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1655_가운데를_말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int median = Integer.parseInt(br.readLine());
        sb.append(median).append("\n");

        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > median) {
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }

            int diff = maxHeap.size() - minHeap.size();
            if (diff > 0) {         // maxHeap이 더 크면
                minHeap.add(median);
                median = maxHeap.poll();
            } else if (diff < -1) { // minHeap이 더 크면
                maxHeap.add(median);
                median = minHeap.poll();
            }

            sb.append(median).append("\n");
//            System.out.println(Arrays.toString(minHeap.toArray()));
//            System.out.println(Arrays.toString(maxHeap.toArray()));
//            System.out.println();
        }

        System.out.print(sb.toString());
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5430_AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {

            // 입력
            String p = br.readLine();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            int[] arr = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            // 연산
            boolean isReverse = false, isError = false;     // isReverse : -> false , <- true, isError : error 처리
            int left = 0, right = N;
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'R') {
                    isReverse = !isReverse;
                } else {
                    if (left == right) {    // 버릴 게 없는데 D가 들어오면 에러
                        isError = true;
                        break;
                    }
                    if (!isReverse) left++;
                    else right--;

                }
            }

            // 출력 처리
            if (isError) sb.append("error");
            else {
                sb.append("[");
                if (!isReverse) {
                    for (int i = left; i < right; i++) {
                        sb.append(arr[i]).append(",");
                    }
                } else if (isReverse) {
                    for (int i = right - 1; i >= left; i--) {
                        sb.append(arr[i]).append(",");
                    }
                }

                if(left < right) // 마지막 쉼표 떼기
                    sb.setLength(sb.length() - 1);

                sb.append("]");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}

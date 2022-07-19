import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2469_사다리_타기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        char[] start = new char[k];
        for(int i = 0; i < k; i++)
            start[i] = (char) ('A' + i);
        char[] end = br.readLine().toCharArray();

        char[][] ladder = new char[n][k];

        for(int i = 0; i < n; i++){
            ladder[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < n; i++){
            if(ladder[i][0] == '?') break;
            start = move(k, start, ladder[i]);
        }

        for(int i = n-1; i >= 0; i--){
            if(ladder[i][0] == '?') break;
            end = move(k, end, ladder[i]);
        }

        char[] answer = hidden(k, start, end);

        for(int i = 0; i < k - 1; i++)
            System.out.print(answer[i]);

    }

    public static char[] move(int k, char[] input, char[] ladder){
        char[] after = input.clone();

        for(int i = 0; i < k - 1; i++){
            if(ladder[i] == '-'){
                after[i] = input[i+1];
                after[i+1] = input[i];
            }
        }

        return after;

    }

    public static char[] hidden(int k, char[] input, char[] output){
        char[] ladder = new char[k-1];
        char[] check = input.clone();
        for(int i = 0; i < k - 1; i++){
            if(input[i] == output[i + 1] && input[i+1] == output[i]){
                ladder[i] = '-';
                check[i] = output[i];
                check[i+1] = output[i+1];
            }

        }

        boolean flag = true;
        for(int i = 0; i < k; i++){
           if(check[i] != output[i]) flag = false;
        }

        if(flag){
            for(int i = 0; i < k-1; i++){
                if(ladder[i] != '-')
                    ladder[i] = '*';
            }
        } else {
            for(int i = 0; i < k-1; i++){
                ladder[i] = 'x';
            }
        }

        return ladder;
    }
}

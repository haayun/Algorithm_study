import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070_파이프_옮기기_1 {
/*
 * 메모리 11720
 * 시간 80
 */
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N+1][N+1];
        int[][][] dp = new int[N+1][N+1][3];
        // 0 : 가로, 1 : 세로, 2 : 대각선
        
        // 입력
        for(int i = 1; i <= N ; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        // 초기 파이프
        dp[1][2][0] = 1;
        
        // dp 연산
        for(int i = 1 ; i <= N ; i++){
            for(int j = 3; j <= N ; j++){
                if(map[i][j] == 0){
                    // 가로 (가로에서 오거나 대각선에서 옴)
                    dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
                    // 세로 (세로에서 오거나 대각선에서 옴)
                    dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
                    // 대각선 (가로 세로 대각선에서 옴)
                    if(map[i-1][j] != 1 && map[i][j-1] != 1){	// 벽인지 체크
                        dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                    }
                }
            }
        }
        // 출력
        System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
    }

}

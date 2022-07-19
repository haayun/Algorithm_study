import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_11559_Puyo_Puyo {

    static int[][] map;
    static int n, m, answer;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = 12;
        m = 6;
        answer = 0;

        map = new int[n][m];
        for(int i = 0; i < n; i++){
            char[] temp = br.readLine().toCharArray();
            for(int j = 0; j < m; j++){
                if(temp[j] == '.')
                    map[i][j] = 0;
                else if (temp[j] == 'R')
                    map[i][j] = 1;
                else if (temp[j] == 'G')
                    map[i][j] = 2;
                else if (temp[j] == 'B')
                    map[i][j] = 3;
                else if (temp[j] == 'P')
                    map[i][j] = 4;
                else map[i][j] = 5;
            }
        }

        while(true){
            int oneTurn = turn();
            if(oneTurn == 0) break;
            answer++;
        }

        System.out.println(answer);

    }

    static int turn(){
        // 같은 색 뿌요 4개 이상 터뜨리기
        int flag = 0;
        for(int i = n-1; i>= 0; i--){
            for(int j= 0; j < m; j++){
                if(map[i][j] > 0){
                    flag += findPuyo(map[i][j], i, j);
                }
            }
        }

        if(flag == 0) return flag;

//        for(int i = 0; i < n; i++){
//            for(int j= 0; j < m; j++)
//                System.out.print(map[i][j]);
//            System.out.println();
//        }


        // 아래로 내리기
        Queue<Integer> queue;
        for(int j = 0; j < m; j++){
            queue = new LinkedList<>();
            for(int i = n - 1; i >= 0; i--){
                if(map[i][j] > 0){
                    queue.add(map[i][j]);
                    map[i][j] = 0;
                }
            }
            int r = n - 1;
            while(!queue.isEmpty()){
                map[r--][j] = queue.poll();
            }
        }

//        for(int i = 0; i < n; i++){
//            for(int j= 0; j < m; j++)
//                System.out.print(map[i][j]);
//            System.out.println();
//        }
//        System.out.println();

        return flag;
    }

    static int findPuyo(int color, int r, int c){
        boolean[][] visited = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(r, c));
        visited[r][c] = true;
        int cnt = 0;
        while(!queue.isEmpty()){

            int cr = queue.peek().r;
            int cc = queue.peek().c;
            queue.poll();

            cnt++;
            for(int i = 0; i < 4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if(nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc]) continue;
                if(map[nr][nc] == color){
                    queue.offer(new Point(nr, nc));
                    visited[nr][nc] = true;
                }
            }

        }

        if(cnt < 4) return 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j])
                    map[i][j] = 0;
            }
        }
        return 1;

    }

    static class Point{
        int r, c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}

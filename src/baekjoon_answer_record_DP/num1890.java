package baekjoon_answer_record_DP;

import java.util.Scanner;

public class num1890 {
    static int N;
    static int[][] table;
    static Long[][] DP;

    public static void main(String[] args) { // dp + dfs
        Scanner sc = new Scanner(System.in);

        // list input
        N = sc.nextInt();
        table = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) {
                table[i][j] = sc.nextInt();
            }
        }

        // start
        DP = new Long[N][N];
        System.out.println(jump(0,0));

    }
    public static long jump (int x, int y) {
        if (x == N-1 && y == N-1) {
            return 1;
        }
        else if (table[y][x] == 0) {
            return 0;
        }
        else{
            if (DP[y][x] == null){
                DP[y][x] = 0L;
                int value = table[y][x];
                if(value <= N-1 - x) { // right
                    DP[y][x] += jump(x+value,y);
                }
                if(value <= N-1 - y) { // down
                    DP[y][x] += jump(x,y+value);
                }
            }
            return DP[y][x];
        }
    }
}

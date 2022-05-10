package baekjoon_answer_record_DP;

import java.util.Scanner;

public class num1520 {
    static int[][] table;
    static Integer[][] DP;
    static int N;
    static int M;

    public static void main(String[] args) { // dp + dfs
        Scanner sc = new Scanner(System.in);

        // list input
        N = sc.nextInt(); // 세로
        M = sc.nextInt(); // 가로
        table  = new int[N][M];
        DP = new Integer[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                table[i][j] = sc.nextInt();
            }
        }

        // start
        System.out.println(dfs(0,0));

        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < M; j++) {
                System.out.print(DP[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
    public static int dfs (int x, int y) {
        if (x == M-1 && y == N-1) {
            return 1;
        }
        else{
            if (DP[y][x] == null) {
                DP[y][x] = 0;
                int height = table[y][x];
                if (x > 0 && table[y][x - 1] < height) { // left
                    DP[y][x] += dfs(x-1 , y);
                }
                if (y > 0 && table[y - 1][x] < height) { // up
                    DP[y][x] += dfs(x , y-1);
                }
                if (x < M - 1 && table[y][x + 1] < height) { // right
                    DP[y][x] += dfs(x+1 , y);
                }
                if (y < N - 1 && table[y + 1][x] < height) { // down
                    DP[y][x] += dfs(x , y+1);
                }
            }
            return DP[y][x];
        }
    }
}

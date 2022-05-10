package baekjoon_practice_space;

import java.util.Scanner;
public class practice_space_3 {
    static int map[][];
    static Integer dp[][];
    static int N;
    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        dp = new Integer[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        System.out.println(logic(0, 0));
    }

    static int logic(int n, int m) {
        if (n == N - 1 && m == M - 1) {
            return 1;
        }
        else {
            if (dp[n][m] == null) {
                dp[n][m] = 0;
                if (n + 1 < N && map[n][m] > map[n + 1][m]) { // down
                    dp[n][m] += logic(n + 1, m);
                }
                if (m + 1 < M && map[n][m] > map[n][m + 1]) { // right
                    dp[n][m] += logic(n, m + 1);
                }
                if (n > 0 && map[n][m] > map[n - 1][m]) { // up
                    dp[n][m] += logic(n - 1, m);
                }
                if (m > 0 && map[n][m] > map[n][m - 1]) { // left
                    dp[n][m] += logic(n, m - 1);
                }
            }
            return dp[n][m];
        }
    }
}

package baekjoon_answer_record_DP;

import java.util.Scanner;

public class num2666 { //dp + DFS
    static int[] b;
    static int n, ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();

        int open1 = sc.nextInt();
        int open2 = sc.nextInt();

        n = sc.nextInt();
        b = new int[n];
        for(int i=0; i<n; i++) {
            b[i] = sc.nextInt();
        }
        go(open1, open2, 0, 0);
        System.out.println(ans);
    }
    static void go(int open1, int open2, int depth, int move) {
        if (depth == n) {
            if (move < ans) ans = move;
            return;
        }
        int tmp1 = Math.abs(open1 - b[depth]);
        int tmp2 = Math.abs(open2 - b[depth]);
        go(open1, b[depth], depth + 1, move + tmp2); //open2를 움직이는 경우
        go(b[depth], open2, depth + 1, move + tmp1); //open1을 움직이는 경우
    }
    /* 자체제작 dp
    static int N;
    static Integer[] open;
    static int M;
    static int[] order;
    static Integer[][][] DP;

    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);

        // list input
        N = sc.nextInt();
        open = new Integer[2];
        for (int i = 0; i < 2; i++) {
            open[i] = sc.nextInt();
        }
        M = sc.nextInt();
        order = new int[M+1];
        for (int i = 1; i <= M; i++) {
            order[i] = sc.nextInt();
        }

        // start
        DP = new Integer[M+1][N][N+1]; // [횟수][열린문(작은 수)][열린문(큰 수)]
        if (open[0] < open[1]) {
            DP[0][open[0]][open[1]] = 0;
        }
        else {
            DP[0][open[1]][open[0]] = 0;
        }
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N-1; j++) {
                for (int k = j+1; k <= N; k++) {
                    if (DP[i-1][j][k] != null) {
                        if (order[i] < j) { // order[i] < j
                            if (DP[i][order[i]][k] == null) {
                                DP[i][order[i]][k] = DP[i-1][j][k] + (j - order[i]);
                            }
                            DP[i][order[i]][k] = Math.min(DP[i-1][j][k] + (j - order[i]), DP[i][order[i]][k]);
                        }
                        else if (order[i] == j) {
                            if (DP[i-1][order[i]][k] != null) {
                                DP[i][order[i]][k] = DP[i-1][order[i]][k];
                            }
                        }
                        else if (order[i] < k) { // j < order[i] < k
                            if (DP[i][order[i]][k] == null) {
                                DP[i][order[i]][k] = DP[i-1][j][k] + (order[i] - j);
                            }
                            if (DP[i][j][order[i]] == null) {
                                DP[i][j][order[i]] = DP[i-1][j][k] + (k - order[i]);
                            }
                            DP[i][order[i]][k] = Math.min(DP[i-1][j][k] + (order[i] - j), DP[i][order[i]][k]);
                            DP[i][j][order[i]] = Math.min(DP[i-1][j][k] + (k - order[i]), DP[i][j][order[i]]);
                        }
                        else if (order[i] == k) {
                            if (DP[i][j][order[i]] == null) {
                                DP[i][j][order[i]] = DP[i - 1][j][order[i]];
                            }
                        }
                        else { // k < order[i]
                            if (DP[i][j][order[i]] == null) {
                                DP[i][j][order[i]] = DP[i-1][j][k] + (order[i] - k);
                            }
                            DP[i][j][order[i]] = Math.min(DP[i-1][j][k] + (order[i] - k), DP[i][j][order[i]]);
                        }
                    }
                }
            }
        }
        int min = -1;
        for (int i = 1; i <= N-1; i++) {
            for (int j = i+1; j <= N; j++) {
                if (DP[M][i][j] == null) {
                    continue;
                }
                if (min == -1) {
                    min = DP[M][i][j];
                }
                min = Math.min(DP[M][i][j], min);
            }
        }
        System.out.println(min);
    }
     */
}

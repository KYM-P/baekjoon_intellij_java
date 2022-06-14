package baekjoon_practice_space;

import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int K;
    static int[][] score; // score[i][j] i 에서 j 로 가는 항로의 기내식 점수
    static int[] DP; // DP[i] i번째 도시 방문에서의 최대 점수
    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);

        // list input
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        score = new int[N+1][N+1];
        for (int k = 0; k < K; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            score[i][j] = Math.max(sc.nextInt(), score[i][j]);
        }
        // start
        DP = new int[N+1];
        move(1,1);
        System.out.println(DP[N]);
    }
    public static void move(int i, int j){
        if (j == M-1) {
            System.out.println(i + " to " + N);
            if (score[i][N] != 0) {
                if (DP[N] < DP[i] + score[i][N]){
                    DP[N] = DP[i] + score[i][N];
                    System.out.println("reload " + i + " to " + N + " = " + DP[N]);
                }
            }
            return;
        }
        for (int k = i+1; k <= N; k++) {
            if (score[i][k] != 0) {
                System.out.println(i + " to " + k);
                if (k == N) {
                    if (DP[k] < DP[i] + score[i][k]){
                        DP[k] = DP[i] + score[i][k];
                        System.out.println("reload " + i + " to " + k + " = " + DP[k]);
                    }
                }
                else {
                    if (DP[k] < DP[i] + score[i][k]){
                        DP[k] = DP[i] + score[i][k];
                        System.out.println("reload " + i + " to " + k + " = " + DP[k]);
                        move(k, j+1);
                    }
                }
            }
        }
    }
}

package baekjoon_practice_space;

import java.util.Scanner;

public class practice_space_1  {
    static int N;
    static int M;
    static short[] K;
    static int[][] DP;
    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);

        // list input
        N = sc.nextInt();
        M = sc.nextInt();

        K = new short[N+1];
        for (int i = 1; i <= N; i++) {
            K[i] = sc.nextShort();
        }

        // start
        DP = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= ((i/2)+(i%2)); j++) {
                if (j > M) {
                    break;
                }
                //DP[i][j] = Math.max(DP[i-1][j],)
            }
        }
    }
}

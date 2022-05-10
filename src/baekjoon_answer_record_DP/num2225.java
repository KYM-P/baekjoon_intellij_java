package baekjoon_answer_record_DP;

import java.util.Scanner;

public class num2225 {
    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);

        // list input
        int N = sc.nextInt();
        int K = sc.nextInt();

        long[][] DP = new long[K+1][N+1];

        // start
        for (int i = 0; i <= N; i++) {
            DP[1][i] = 1;
        }
        for (int i = 2; i <= K; i++){
            for (int j = 0; j <= N; j++) {
                for (int k = 0; k <= j; k++) {
                    DP[i][j] += (DP[i-1][j-k])%1000000000;
                }
            }
        }
        System.out.println(DP[K][N] % 1000000000);
    }
}

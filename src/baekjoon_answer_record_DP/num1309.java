package baekjoon_answer_record_DP;

import java.util.Scanner;

public class num1309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // list input
        int N = sc.nextInt();
        int div = 9901;

        // start
        int[][] DP = new int[N+1][3];
        DP[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            DP[i][0] = (DP[i-1][0] + DP[i-1][1] + DP[i-1][2])%div;
            DP[i][1] = (DP[i-1][0] + DP[i-1][2])%div;
            DP[i][2] = (DP[i-1][0] + DP[i-1][1])%div;
        }
        int result = (DP[N][0] + DP[N][1] + DP[N][2])%div;

        System.out.println(result);
        System.out.println(other(N,div));
    }

    public static int other (int N, int div) {
        int[] DP = new int[N+1];
        DP[0] = 1;
        DP[1] = 3;
        for (int i = 2; i <= N; i++) {
            DP[i] += (DP[i-1])%div;
            DP[i] += (DP[i-2] * 2)%div;
            if (DP[i-1] - DP[i-2] < 0){
                DP[i] += (DP[i-1] - DP[i-2] + div)%div;
            }
            else {
                DP[i] += (DP[i-1] - DP[i-2])%div;
            }
        }
        return DP[N] % div;
    }
}

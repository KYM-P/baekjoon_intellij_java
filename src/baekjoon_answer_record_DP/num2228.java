package baekjoon_answer_record_DP;

import java.util.Scanner;

public class num2228 {
    static int N;
    static int M;
    static short[] K;
    static Integer[][][] DP; // [길이][분할 수][Delta]

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
        DP = new Integer[N+1][M+1][2]; // [][][0] = 값, [][][] = Delta
        DP[0][0][0] = 0;
        DP[1][0][0] = 0;
        DP[1][1][0] = (int)K[1];
        DP[1][1][1] = 0;
        for (int i = 2; i <= N; i++) {
            DP[i][0][0] = 0;
            for (int j = 1; j <= ((i/2)+(i%2)); j++) {
                if (j > M) {
                    break;
                }
                if (j > 1 && DP[i-1][j][0] == null) {
                    DP[i][j][0] = DP[i-2][j-1][0] + K[i];
                    DP[i][j][1] = 0;
                }
                else {
                    DP[i][j][1] = DP[i-1][j][1] + 1;
                    DP[i][j][0] = DP[i-1][j][0];
                    int max = 0;
                    for (int k = 0; k <= DP[i-1][j][1]; k++) {
                        max += K[i-k];
                        if (DP[i-2-k][j-1][0] + max >= DP[i][j][0]) {
                            DP[i][j][0] = DP[i-2-k][j-1][0] + max;
                            DP[i][j][1] = 0;
                        }
                    }
                    if (DP[i-1][j][0] + max >= DP[i-1][j][0] && DP[i-1][j][0] + max >= DP[i][j][0]) {
                        DP[i][j][0] = DP[i-1][j][0] + max;
                        DP[i][j][1] = 0;
                    }
                }
            }
            //System.out.println(i + " " + DP[i][1][0]);
        }
        System.out.println(DP[N][M][0]);
    }
}

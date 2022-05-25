package baekjoon_answer_record_DP;

import java.util.Scanner;

public class num1562 {
    static int div = 1000000000;
    static long[][][] DP;
    static int Bm = (1<<10) - 1;
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        // start
        int N = sc.nextInt();
        DP = new long[N+1][10][Bm + 1]; // [길이][맨앞 숫자][비트마스크]

        for (int i = 0; i < 10; i ++) {
            DP[1][i][1<<i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 1; k <= Bm; k++) {
                    if (j-1 >= 0) {
                        DP[i][j][k | 1 << j] += DP[i-1][j-1][k] % div;
                    }
                    if (j+1 <= 9) {
                        DP[i][j][k | 1 << j] += DP[i-1][j+1][k] % div;
                    }
                }
            }
        }
        long result = 0;
        for (int i = 1; i < 10; i++) {
            result += DP[N][i][Bm];
        }
        System.out.println(result % div);
    }
}

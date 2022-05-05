package baekjoon_answer_record_DP;

import java.util.Scanner;

public class num10844 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        // start
        int N = sc.nextInt();

        long[][] DPT1 = new long[N+1][10];
        for (int i = 0; i < 10; i ++) {
            DPT1[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j-1 >= 0) {
                    DPT1[i][j] += DPT1[i-1][j-1] % 1000000000;
                }
                if (j+1 <= 9) {
                    DPT1[i][j] += DPT1[i-1][j+1] % 1000000000;
                }
            }
        }
        long result = 0;
        for (int i = 1; i < 10; i++) {
            result += DPT1[N][i];
        }
        System.out.println(result % 1000000000);
    }
}

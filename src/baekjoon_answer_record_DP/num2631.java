package baekjoon_answer_record_DP;

import java.util.Scanner;

public class num2631 {
    public static void main(String[] args) { // dp + LIS
        Scanner sc = new Scanner(System.in);

        // list input
        int N = sc.nextInt();
        int[] line = new int[N];

        for (int i = 0; i < N; i++) {
            line[i] = sc.nextInt();
        }

        // start
        int[] DP = new int[N];
        DP[0] = 1;
        int maxline = 1;
        for (int i = 1; i < N; i++) {
            DP[i] = 1;
            for (int j = 0; j < i; j++) {
                if (line[i] > line[j]) {
                    DP[i] = Math.max(DP[i],DP[j] + 1);
                    maxline = Math.max(maxline,DP[i]);
                }
            }
        }
        System.out.println(N - maxline);
    }
}

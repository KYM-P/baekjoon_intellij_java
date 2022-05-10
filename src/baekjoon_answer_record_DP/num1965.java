package baekjoon_answer_record_DP;

import java.util.Scanner;

public class num1965 {
    public static void main(String[] args) { // LIS
        Scanner sc = new Scanner(System.in);

        // list input
        int N = sc.nextInt();

        int[] table = new int[N];
        for (int i = 0; i < N; i++) {
            table[i] = sc.nextInt();
        }

        // start
        int result = 1;

        int[] DP = new int[N];
        DP[0] = 1;

        for (int i = 1; i < N; i++) {
            DP[i] = 1;
            for (int j = 0; j < i; j++) {
                if (table[i] > table[j]) {
                    DP[i] = Math.max(DP[i],DP[j] + 1);
                    result = Math.max(DP[i],result);
                }
            }
        }
        System.out.println(result);
    }
}

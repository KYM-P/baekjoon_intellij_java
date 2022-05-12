package baekjoon_answer_record_DP;

import java.util.Scanner;

public class num2096 {
    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);

        // list input
        int N = sc.nextInt();
        int[][] table = new int[N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j] = sc.nextInt();
            }
        }

        // start
        int[][] Max = new int[N][3];
        int[][] Min = new int[N][3];
        Max[0][0] = table[0][0];
        Max[0][1] = table[0][1];
        Max[0][2] = table[0][2];
        Min[0][0] = table[0][0];
        Min[0][1] = table[0][1];
        Min[0][2] = table[0][2];
        for (int i = 1; i < N; i++) {
            // Max
            Max[i][0] = Math.max(Max[i-1][0],Max[i-1][1]) + table[i][0];
            Max[i][1] = Math.max(Math.max(Max[i-1][0],Max[i-1][1]), Max[i-1][2]) + table[i][1];
            Max[i][2] = Math.max(Max[i-1][1],Max[i-1][2]) + table[i][2];
            // Min
            Min[i][0] = Math.min(Min[i-1][0],Min[i-1][1]) + table[i][0];
            Min[i][1] = Math.min(Math.min(Min[i-1][0],Min[i-1][1]), Min[i-1][2]) + table[i][1];
            Min[i][2] = Math.min(Min[i-1][1],Min[i-1][2]) + table[i][2];
        }
        System.out.print(Math.max(Math.max(Max[N-1][0],Max[N-1][1]), Max[N-1][2]));
        System.out.print(" ");
        System.out.println(Math.min(Math.min(Min[N-1][0],Min[N-1][1]), Min[N-1][2]));
    }
}

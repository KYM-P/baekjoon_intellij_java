package baekjoon_practice_space;

import java.util.Scanner;

public class practice_space_1  {
    static int N;
    static int[][] DP;
    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);

        // list input
        N = sc.nextInt();
        N = N/2; // 내림
        // start
        DP = new int[500001][21]; // 2^20 = 1,048,576    2^i 값이 최대인 표현법들 메모
        DP[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            DP[i][0] = 1;
            for (int j = 1; Math.pow(2,j) <= i*2; j++) {
                DP[i][j] += DP[i - (int)Math.pow(2,j-1)][0];
                for (int k = 1; Math.pow(2,k) <= i*2 - (int)Math.pow(2,j); k++){
                    DP[i][j] += DP[i - (int)Math.pow(2,j-1)][k];
                }
            }
        }
        int result = 0;
        for (int i = 0; i < 21; i++) {
            System.out.println(i + " " + DP[N][i]);
            result += DP[N][i];
        }
        System.out.println(result);
    }
}

package baekjoon_practice_space;

import java.util.Scanner;

public class practice_space_1  {
    static int N;
    static long[][][] DP;
    static int div = 1000000000;
    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);

        // list input
        N = sc.nextInt();

        // start
        DP = new long[N+1][10][10]; // [����][���۰�][����]
        DP[10][9][0] = 1;
        DP[10][0][9] = 1;
        for (int i = 11; i <= N; i++) {
            for (int j = 0; j < 10; j++) { // ���۰�

            }
        }

        int result = 0;
        for (int i = 1; i < 10; i++) { // ���۰�
            for (int j = 0; j < 10; j++) { // ����
                result += DP[N][i][j]%div;
                result %= div;
            }
        }
        System.out.println(result%div);
    }
}

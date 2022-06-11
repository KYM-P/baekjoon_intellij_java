package baekjoon_practice_space;

import java.util.Scanner;

public class Main {
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
        DP[1][0] = 1;
        start(1,1);

    }
    public static void start(int i, int j) {
        if (Math.pow(2,j) > i*2) {
            DP[i+1][j] = 1;
            start(i+1, 1);
            return;
        }
        else {
            DP[i][j] = DP[i-1][j];
        }
    }
}

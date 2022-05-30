package baekjoon_practice_space;

import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[][] task;
    static int min = Integer.MAX_VALUE;
    static int[][] DP;
    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);

        // list input
        N = sc.nextInt();
        M = sc.nextInt();
        task = new int[M+1][2];
        for (int i = 1; i <= M; i++) {
            task[i][0] = sc.nextInt();
            task[i][1] = sc.nextInt();
        }

    }
}

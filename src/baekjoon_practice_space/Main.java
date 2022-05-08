package baekjoon_practice_space;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        // list input
        int M = sc.nextInt(); // 세로
        int N = sc.nextInt(); // 가로

        int[][] table = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                table[i][j] = sc.nextInt();
            }
        }

        // start
    }
}

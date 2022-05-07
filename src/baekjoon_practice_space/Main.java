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

        int[][][] table = new int[N+1][M+1][1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                table[i][j][1] = sc.nextInt();
            }
        }

        int h = 1;
        int w = 1;
        table[w][h][1] = 1;
        Queue<Integer[]> queue = new LinkedList<>();
        // start
    }
}

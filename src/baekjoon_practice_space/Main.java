package baekjoon_practice_space;

import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map;
    static int bitm = 0;
    static int mini = 0;
    static Integer[][] DP;
    public static void main(String[] args) { // TSP(TSProblem) dp + BitMask
        Scanner sc = new Scanner(System.in);

        // list input
        N = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // start

        DP = new Integer[(1<<N)-1][N]; // DP[bitmask][N]
        bitm = 1;
    }
    public static void root(int start, int bm) {
        for (int i = 1; i < N; i++) {
            if ((bm & (1 << i)) == 0 && map[start][i] != 0) { // i 번째 Node 통과 여부
                bitm = (bitm | (1 << i));
                mini += map[start][i];
                root(i,bitm);

            }
        }
    }
}

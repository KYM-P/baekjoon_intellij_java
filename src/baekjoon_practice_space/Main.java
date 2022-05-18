package baekjoon_practice_space;

import java.awt.event.MouseAdapter;
import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map;
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
        // DP[bm][i] = 현재 있는 도시 i, 방문한 기록 bm 일때,
        root(0,1);
    }
    public static int root(int start, int bm) {
        if (bm == (1<<N)-1) {
            return map[start][0];
        }
        if (DP[bm][start] != null) {
            return DP[bm][start];
        }
        for (int i = 1; i < N; i++) {
            if ((bm & (1 << i)) == 0 && map[start][i] != 0) { // i 번째 Node 통과 여부
                DP[bm][start] = Math.min(DP[bm][start], root(i,(bm | (1 << i)) + map[start][i]);
            }
        }
        return DP[bm][start];
    }
}

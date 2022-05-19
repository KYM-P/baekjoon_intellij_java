package baekjoon_answer_record_DP;

import java.util.Scanner;

public class num2098 {
    static int N;
    static int[][] map;
    static Integer[][] DP;
    static int inf = 1000000000;
    public static void main(String[] args) { // TSP(TSProblem) / dp + BitMask + dfs
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
        // DP[bm][i] = 현재 있는 도시가 i, 방문한 기록이 bm 일 때 0까지 가는 최소 거리
        System.out.println(root(0,1));
    }
    public static int root(int start, int bm) {
        if (bm == (1<<N)-1) {
            if (map[start][0] == 0) {
                return inf;
            }
            return map[start][0];
        }
        if (DP[bm][start] != null) {
            return DP[bm][start];
        } else {
            DP[bm][start] = inf;
        }
        for (int i = 1; i < N; i++) {
            if ((bm & (1 << i)) == 0 && map[start][i] != 0) { // i 번째 Node 통과 여부
                DP[bm][start] = Math.min(DP[bm][start], root(i,(bm | (1 << i))) + map[start][i]);
            }
        }
        return DP[bm][start];
    }
}

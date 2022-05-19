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
        // DP[bm][i] = ���� �ִ� ���ð� i, �湮�� ����� bm �� �� 0���� ���� �ּ� �Ÿ�
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
            if ((bm & (1 << i)) == 0 && map[start][i] != 0) { // i ��° Node ��� ����
                DP[bm][start] = Math.min(DP[bm][start], root(i,(bm | (1 << i))) + map[start][i]);
            }
        }
        return DP[bm][start];
    }
}

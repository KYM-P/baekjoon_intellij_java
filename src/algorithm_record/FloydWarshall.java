package algorithm_record;

public class FloydWarshall {
    static int[][] table;
    static int[][] DP;
    static int inf = 1000000000;
    static int N;
    public static void main (String[] args) {
        N = 4;
        table = new int[N][N];
        DP = new int[N][N];

        table[0][0] = 0;
        table[0][1] = 5;
        table[0][2] = inf;
        table[0][3] = 8;

        table[1][0] = 7;
        table[1][1] = 0;
        table[1][2] = 9;
        table[1][3] = inf;

        table[2][0] = 2;
        table[2][1] = inf;
        table[2][2] = 0;
        table[2][3] = 4;

        table[3][0] = inf;
        table[3][1] = inf;
        table[3][2] = 3;
        table[3][3] = 0;

        DP = table;
        fw();
        show();
    }
    public static void fw() {
        for (int i = 0; i < N; i++) { // 거쳐가는 Node
            for (int j = 0; j < N; j++) { // 출발지 Node
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < N; k++) { // 도착지 Node
                    if (j == k || i == k) {
                        continue;
                    }
                    /*
                    System.out.println("i: " + i + " j: " + j + " k: " + k);
                    System.out.println(DP[j][k] + " / " + DP[j][i] + " + " + DP[i][k]);
                     */
                    if (DP[j][k] > DP[j][i] + DP[i][k]) {
                        DP[j][k] = DP[j][i] + DP[i][k];
                    }
                }
            }
        }
    }

    public static void show() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print( table[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

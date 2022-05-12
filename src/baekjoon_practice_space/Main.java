package baekjoon_practice_space;

import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) { // dp   TSP(TSProblem)
        Scanner sc = new Scanner(System.in);

        // list input
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // start
    }
}

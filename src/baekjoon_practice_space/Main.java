package baekjoon_practice_space;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int K;
    static int[][] score; // score[i][j] i 에서 j 로 가는 항로의 기내식 점수
    static int[][] DP; // DP[i][k] i번째 도시 k 번째 방문에서의 점수
    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);

        // list input
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        score = new int[N + 1][N + 1];
        for (int k = 0; k < K; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            score[i][j] = Math.max(sc.nextInt(), score[i][j]);
        }
        // start
        DP = new int[N + 1][N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int count = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int x  = q.poll();

            }

        }
    }
}

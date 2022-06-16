package baekjoon_practice_space;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class practice_space_1  {
    static int N;
    static int M;
    static int K;
    static LinkedList<Integer>[] score; // score[i][j] i 에서 j 로 가는 항로의 기내식 점수
    static int[][] DP; // DP[i][k] i번째 도시 k 번째 방문에서의 점수
    static int max = 0;
    public static void main(String[] args) throws IOException { // dp

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        // list input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {

        }
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            score[i][j] = Math.max(Integer.parseInt(st.nextToken()), score[i][j]);
        }
        // start
        DP = new int[N+1][M+1];
        move(1,1);
        System.out.println(max);
    }
    public static void move(int i, int j){
        if (j == M-1) {
            if (score[i][N] != 0) {
                if (DP[N][j+1] < DP[i][j] + score[i][N]){
                    DP[N][j+1] = DP[i][j] + score[i][N];
                    max = Math.max(max, DP[N][j+1]);
                }
            }
            return;
        }
        for (int k = i+1; k <= N; k++) {
            if (score[i][k] != 0) {
                if (k == N) {
                    if (DP[k][j+1] < DP[i][j] + score[i][k]){
                        DP[k][j+1] = DP[i][j] + score[i][k];
                        max = Math.max(max, DP[k][j+1]);
                    }
                }
                else {
                    if (DP[k][j+1] < DP[i][j] + score[i][k]){
                        DP[k][j+1] = DP[i][j] + score[i][k];
                        move(k, j+1);
                    }
                }
            }
        }
    }
}

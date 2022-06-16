package baekjoon_practice_space;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class practice_space_1  {
    static int N;
    static int M;
    static int K;
    static int[][] score; // score[i][j] i ���� j �� ���� �׷��� �⳻�� ����
    static LinkedList<Integer>[] next; // next[i] i ���� �� �� �ִ� ��� ����Ʈ
    static int[][] DP; // DP[i][k] i��° ���� k ��° �湮������ ����
    static int max = 0;
    public static void main(String[] args) throws IOException { // dp

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        // list input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        score = new int[N+1][N+1];

        next = new LinkedList[N+1];
        for (int i = 1; i <= N; i++) {
            next[i] = new LinkedList<>();
        }

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            if (i >= j) {
                continue;
            }
            else {
                next[i].add(j);
                if (score[i][j] <= s) {
                    score[i][j] = s;
                }
                else {
                    next[i].removeLast();
                }
            }
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
        for (int k : next[i]) {
            if (k == N) {
                if (DP[k][j+1] < DP[i][j] + score[i][k]){
                    DP[k][j+1] = DP[i][j] + score[i][k];
                    max = Math.max(max, DP[k][j+1]);
                }
            }
            else{
                if (DP[k][j+1] < DP[i][j] + score[i][k]){
                    DP[k][j+1] = DP[i][j] + score[i][k];
                    move(k, j+1);
                }
            }
        }
    }
}

package baekjoon_practice_space;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int K;
    static int[][] score; // score[i][j] i 에서 j 로 가는 항로의 기내식 점수
    static LinkedList<Integer>[] next; // next[i] i 에서 갈 수 있는 경로 리스트
    static int[][] DP; // DP[i][k] i번째 도시 k 번째 방문에서의 점수
    static int max;
    public static void main(String[] args) throws IOException { // dp

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        // list input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        score = new int[N + 1][N + 1];
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
        DP = new int[N + 1][N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int count = 1;

        while (!q.isEmpty() && count < M) {
            int size = q.size();
            while (size > 0) {
                int x  = q.poll();
                for (int nextx : next[x]) {
                    if (DP[nextx][count+1] < DP[x][count] + score[x][nextx]){
                        q.add(nextx);
                        DP[nextx][count+1] = DP[x][count] + score[x][nextx];
                        if (nextx == N) {
                            max = Math.max(max ,DP[nextx][count+1]);
                        }
                    }
                }
                size--;
            }
            count++;
        }
        System.out.println(max);
    }
}

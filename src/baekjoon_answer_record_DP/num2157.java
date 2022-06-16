package baekjoon_answer_record_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num2157 {
    static int N;
    static int M;
    static int K;
    static int[][] score; // score[i][j] i ���� j �� ���� �׷��� �⳻�� ����
    static LinkedList<Integer>[] next; // next[i] i ���� �� �� �ִ� ��� ����Ʈ
    static int[][] DP; // DP[i][k] i��° ���� k ��° �湮������ ����
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
    /* Ÿ���� �ڵ�
    private static int dp[][];

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // DP[M][N] = M�� ���� �湮 ���� �� ���� ���� ��ȣ�� N
        dp = new int[M+1][N+1];

        List<Node> boards[] = new List[N+1];

        for(int i=0;i<=N;i++){
            boards[i]=new ArrayList<>();
        }

        for(int i=0;i<K;i++){

            st = new StringTokenizer(bf.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a > b){
                continue;
            }

            boards[a].add(new Node(b,c));
        }

        int result=0;

        Queue<Integer> q = new LinkedList<>();

        q.add(1);

        int cnt=1;

        while(!q.isEmpty() && cnt < M){

            int size = q.size();

            while(size-- > 0){
                int nowIndex = q.poll();
                for(Node nextNode : boards[nowIndex]){

                    int nextIndex = nextNode.index;
                    int nextnext = dp[cnt][nowIndex]+nextNode.next;

                    if(dp[cnt+1][nextIndex] >= nextnext){
                        continue;
                    }

                    dp[cnt+1][nextIndex] = nextnext;

                    q.add(nextIndex);

                }

            }
            cnt++;

        }

        for(int i=2;i<=M;i++){
            result = Integer.max(result,dp[i][N]);
        }

        System.out.println(result);


    }

    public static class Node{
        int index;
        int next;

        public Node(int index, int next) {
            this.index = index;
            this.next = next;
        }
    }
     */
}

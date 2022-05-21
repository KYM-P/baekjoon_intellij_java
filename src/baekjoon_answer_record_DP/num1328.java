package baekjoon_answer_record_DP;

import java.util.Scanner;

public class num1328 {
    static int N;
    static int L;
    static int R;
    static long[][][] DP;
    static int div = 1000000007;
    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);

        // list input
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();

        // start
        DP = new long[N+1][N+1][N+1]; // DP[i][L][R] i번째 L R 일 때의 경우의 수
        DP[1][1][1] = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                for (int k = 1; k <= j; k++) {
                    DP[i][k][j-k+1] += DP[i-1][k-1][j-k+1] + DP[i-1][k][j-k] + DP[i-1][k][j-k+1]*(i-2);
                    DP[i][k][j-k+1] %= div;
                }
            }
        }
        System.out.println(DP[N][L][R]);
    }
    /*
    1. N-1개의 빌딩이 있고, 왼쪽에서 L-1개의 빌딩이 보일 때 빌딩의 높이를 1씩 높이고, 높이 1인 빌딩을 맨 왼쪽에 배치한 경우(solve(N-1, L-1, R))

    2. N-1개의 빌딩이 있고, 오른쪽에서 R-1개의 빌딩이 보일 때 빌딩의 높이를 1씩 높이고, 높이 1인 빌딩을 맨 오른쪽에 배치한 경우(solve(N-1, L, R-1))

    3. N-1개의 빌딩이 있고, 왼쪽에서 L개 오른쪽에서 R개의 빌딩이 보일 때 빌딩의 높이를 1씩 높이고, 높이 1인 빌딩을 중간에 위치시키는 경우.(solve(N-1, L, R) * (N-2))
     */
}

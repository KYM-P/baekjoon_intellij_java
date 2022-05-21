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
        DP = new long[N+1][N+1][N+1]; // DP[i][L][R] i��° L R �� ���� ����� ��
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
    1. N-1���� ������ �ְ�, ���ʿ��� L-1���� ������ ���� �� ������ ���̸� 1�� ���̰�, ���� 1�� ������ �� ���ʿ� ��ġ�� ���(solve(N-1, L-1, R))

    2. N-1���� ������ �ְ�, �����ʿ��� R-1���� ������ ���� �� ������ ���̸� 1�� ���̰�, ���� 1�� ������ �� �����ʿ� ��ġ�� ���(solve(N-1, L, R-1))

    3. N-1���� ������ �ְ�, ���ʿ��� L�� �����ʿ��� R���� ������ ���� �� ������ ���̸� 1�� ���̰�, ���� 1�� ������ �߰��� ��ġ��Ű�� ���.(solve(N-1, L, R) * (N-2))
     */
}

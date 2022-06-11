package baekjoon_answer_record_DP;

import java.util.Scanner;

public class num2410 {
    static int N;
    static int[][] DP;
    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);

        // list input
        N = sc.nextInt();
        N = N/2; // ����
        // start
        int div = 1000000000;
        // DP[i][j] Ȧ���� ���� �ٷ��� ¦���� ���� ����� ���� �����Ƿ� �ش� ¦���� �����͸� �޸��ϱ� ���� Ȧ���� ����¦���� ��ȯ�Ͽ� ����
        DP = new int[500001][21]; // 2^20 = 1,048,576  i*2(¦���� �ٲ� ������) �� �϶�   2^j ���� �ִ��� ǥ������ �޸�
        DP[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            DP[i][0] = 1;
            for (int j = 1; Math.pow(2,j) <= i*2; j++) {
                DP[i][j] += DP[i - (int)Math.pow(2,j-1)][0] % div;
                DP[i][j] %= div;
                for (int k = 1; k <= j; k++){
                    DP[i][j] += DP[i - (int)Math.pow(2,j-1)][k] % div;
                    DP[i][j] %= div;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < 21; i++) {
            // System.out.println(i + " " + DP[N][i]);
            result += DP[N][i];
            result %= div;
        }
        System.out.println(result % div);
    }
}

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
    /*
    private static int dp[][];
    private static int MOD = 1000000000;
    private static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        dp = new int[n+1][20]; // 0, 0 ���Ⱦ�


        System.out.println(dinamic_programming(n, 19));


		 * �����ϰ� Ǫ�·���
		int dp2[] = new int[n+1];
		dp2[0] = 1;
		dp2[1] = 1;
		for(int i = 2 ; i <= n ; i ++)
			dp2[i] = (dp2[i-2] + dp2[i/2])%MOD;
		System.out.println(dp2[n]);
} //DP ���
    private static int dinamic_programming(int i , int j) {
        if(i < 0)
            return 0;

        if(i == 0)
            return 1;

        if(i > 0 && j == 0)
            return dp[i][0] = 1;

        if(dp[i][j] != 0)
            return dp[i][j];

        int check = i - (int)Math.pow(2 , j);

        if (check >= 0) {
            return (dp[i][j-1] = dinamic_programming(i, j - 1) % MOD) + (dp[check][j] = dinamic_programming(check, j) % MOD);
        }else {
            return dp[i][j] = dinamic_programming(i , j-1) % MOD;
        }
    }
     */
}

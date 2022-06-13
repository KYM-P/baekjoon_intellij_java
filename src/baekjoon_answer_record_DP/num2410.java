package baekjoon_answer_record_DP;

import java.util.Scanner;

public class num2410 {
    static int N;
    static int[][] DP;
    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);

        // list input
        N = sc.nextInt();
        N = N/2; // 내림
        // start
        int div = 1000000000;
        // DP[i][j] 홀수일 때는 바로전 짝수일 때의 경우의 수와 같으므로 해당 짝수의 데이터만 메모하기 위해 홀수를 내림짝수로 변환하여 저장
        DP = new int[500001][21]; // 2^20 = 1,048,576  i*2(짝수로 바꾼 원본값) 값 일때   2^j 값이 최대인 표현법들 메모
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

        dp = new int[n+1][20]; // 0, 0 은안씀


        System.out.println(dinamic_programming(n, 19));


		 * 간단하게 푸는로직
		int dp2[] = new int[n+1];
		dp2[0] = 1;
		dp2[1] = 1;
		for(int i = 2 ; i <= n ; i ++)
			dp2[i] = (dp2[i-2] + dp2[i/2])%MOD;
		System.out.println(dp2[n]);
} //DP 사용
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

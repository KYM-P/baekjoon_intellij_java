package baekjoon_practice_space;

import java.util.Scanner;

public class practice_space_2 {
    private static int dp[][];
    private static int MOD = 1000000000;
    private static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        dp = new int[n+1][20]; // 0, 0 은안씀


        System.out.println(dinamic_programming(n, 19));


		/*
		 * 간단하게 푸는로직
		int dp2[] = new int[n+1];
		dp2[0] = 1;
		dp2[1] = 1;
		for(int i = 2 ; i <= n ; i ++)
			dp2[i] = (dp2[i-2] + dp2[i/2])%MOD;
		System.out.println(dp2[n]);
		*/
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
}

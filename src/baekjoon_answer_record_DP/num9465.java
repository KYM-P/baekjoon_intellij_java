package baekjoon_answer_record_DP;

import java.util.Scanner;
import java.util.ArrayList;


public class num9465 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Test_Case = sc.nextInt();

        ArrayList<int[][]> Table = new ArrayList<>();
        ArrayList<int[]> dp_last_up = new ArrayList<>();
        ArrayList<int[]> dp_last_down = new ArrayList<>();

        // List Input
        for (int Case = 0; Case < Test_Case; Case ++) {

            int n = sc.nextInt();

            Table.add(new int[2][n]);
            dp_last_up.add(new int[n]);
            dp_last_down.add(new int[n]);

            for (int column = 0; column < 2; column++) {
                for (int line = 0; line < n; line++) {
                    Table.get(Case)[column][line] = sc.nextInt();
                }
            }
        }

        for (int Case = 0; Case < Test_Case; Case++) {

            if ( Table.get(Case)[0].length == 1) {
                System.out.println(Math.max(Table.get(Case)[0][0],Table.get(Case)[1][0]));
            }

            else if (Table.get(Case)[0].length == 2) {
                System.out.println(Math.max(Table.get(Case)[0][0] + Table.get(Case)[1][1],Table.get(Case)[1][0] + Table.get(Case)[0][1]));
            }

            else {
                int length = Table.get(Case)[0].length;
                dp_last_up.get(Case)[0] = Table.get(Case)[0][0];
                dp_last_down.get(Case)[0] = Table.get(Case)[1][0];
                dp_last_up.get(Case)[1] = dp_last_down.get(Case)[0] + Table.get(Case)[0][1];
                dp_last_down.get(Case)[1] = dp_last_up.get(Case)[0] + Table.get(Case)[1][1];

                for (int line = 2; line < length; line++) {
                    dp_last_up.get(Case)[line] = Math.max(dp_last_down.get(Case)[line-1], dp_last_down.get(Case)[line-2]) + Table.get(Case)[0][line];
                    dp_last_down.get(Case)[line] = Math.max(dp_last_up.get(Case)[line-1], dp_last_up.get(Case)[line-2]) + Table.get(Case)[1][line];
                    //System.out.println("up:" + dp_last_up.get(Case)[line] + "down:" + dp_last_down.get(Case)[line]);
                }
                System.out.println(Math.max(dp_last_up.get(Case)[length - 1], dp_last_down.get(Case)[length - 1]));

            }

        }
    }
    // another short coding
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];
            for (int j = 0; j < 2; j++) { //ÃÊ±âÈ­
                for (int k = 1; k <= n; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            for (int a = 2; a <= n; a++) {
                dp[0][a] = Math.max(dp[1][a - 1], dp[1][a - 2]) + arr[0][a];
                dp[1][a] = Math.max(dp[0][a - 1], dp[0][a - 2]) + arr[1][a];
            }
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}

package baekjoon_practice_space;

import java.util.Scanner;

public class practice_space_1  {
    static int N;
    static String table;
    static String goal;
    static int[] DP;
    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);

        // list input
        N = sc.nextInt();
        table = sc.nextLine();
        goal = sc.nextLine();

        // start
        DP = new int[N+1];
        for (int i = 1; i <= N; i++) {
            int count_1 = 0;
            if (table.charAt(i-1) > goal.charAt(i-1)) {
                count_1 = Math.abs(table.charAt(i-1) - goal.charAt(i-1) - '0');
                count_1 = Math.min((10 - (table.charAt(i-1) - '0')) + (goal.charAt(i-1) - '0'), count_1);
            }
            else if (table.charAt(i-1) > goal.charAt(i-1)) {
                count_1 = Math.abs(table.charAt(i-1) - goal.charAt(i-1) - '0');
                count_1 = Math.min((10 - (goal.charAt(i-1) - '0')) + (table.charAt(i-1) - '0'), count_1);
            }
            else if (table.charAt(i-1) == goal.charAt(i-1)) {
                count_1 = 0;
            }
            count_1 = count_1 / 3 + ((count_1%3 > 0)?1:0);
            DP[i] = count_1 + DP[i-1];
            if (i > 1) {
                int count_2 = 0;

            }
            if (i > 3) {
                int count_3 = 0;
            }
        }
    }
}

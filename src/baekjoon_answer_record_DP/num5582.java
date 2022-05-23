package baekjoon_answer_record_DP;

import java.util.Scanner;

public class num5582 {
    static String str1;
    static String str2;
    static int[][] DP;
    static int result = 0;
    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);

        // list input
        str1 = sc.nextLine();
        str2 = sc.nextLine();

        // start
        DP = new int[str1.length()][str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i > 0 && j > 0) {
                        DP[i][j] = DP[i-1][j-1] + 1;
                    }
                    else {
                        DP[i][j] = 1;
                    }
                    result = Math.max(DP[i][j], result);
                }
            }
        }
        System.out.println(result);
    }
}

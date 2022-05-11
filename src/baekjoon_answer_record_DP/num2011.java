package baekjoon_answer_record_DP;

import java.util.Scanner;

public class num2011 {
    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);

        // list input
        String N = sc.nextLine();

        // start
        long[] DP = new long[N.length()];
        DP[0] = 1;
        int div = 1000000;
        if (((int)N.charAt(0) - '0') == 0) {
            System.out.println(0);
            return;
        }
        for (int i = 1; i < N.length(); i++) {
            if (((int)N.charAt(i) - '0') > 0) {
                DP[i] += (DP[i-1])%div;
            }
            int c = ((int)N.charAt(i) - '0') + ((int)N.charAt(i-1) - '0') * 10;
            if (i > 1 && ((int)N.charAt(i-1) - '0') == 0 && ((int)N.charAt(i-2) - '0') > 2 && ((int)N.charAt(i-2) - '0' < 1)) {
                System.out.println(0);
                return;
            }
            if ( c < 27 && c > 9) {
                if (i == 1) {
                    DP[i] += 1;
                }
                else {
                    DP[i] += (DP[i-2])%div;
                }
            }
        }
        System.out.println(DP[N.length()-1]%div);
    }
}

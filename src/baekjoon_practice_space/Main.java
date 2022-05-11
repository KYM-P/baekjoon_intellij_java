package baekjoon_practice_space;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // list input
        String N = sc.nextLine();

        // start
        int[] DP = new int[N.length()];
        DP[0] = 1;
        int div = 1000000;

        for (int i = 1; i < N.length(); i++) {
            DP[i] += (DP[i-1])%div;
            if (((int)N.charAt(i) - '0') + ((int)N.charAt(i-1) - '0') * 10 < 27) {
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

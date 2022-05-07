package baekjoon_answer_record_DP;

import java.util.Scanner;

public class num2133 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        // start
        int N = sc.nextInt();

        int[] DPT1 = new int[N+1];
        if (N >= 2) {
            DPT1[2] = 3;
        }
        for (int i = 4; i <= N; i+=2) {
            DPT1[i] += DPT1[i - 2] * 3;
            int j = 4;
            while (i - j > 0) {
                DPT1[i] += DPT1[i - j] * 2;
                j += 2;
            }
            DPT1[i] += 2;
        }
        System.out.println(DPT1[N]);
    }
}

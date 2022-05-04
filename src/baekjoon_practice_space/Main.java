package baekjoon_practice_space;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] DPT1 = new int[k+1];

        for (int i = 0; i < n; i ++) {
            int coin = sc.nextInt();
            if (coin <= k){
                DPT1[coin] += 1;
            }
            for (int j = coin; j <= k; j ++) {
                DPT1[j] += DPT1[j - coin];
            }
        }
        System.out.println(DPT1[k]);
    }
}

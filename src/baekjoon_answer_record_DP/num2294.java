package baekjoon_answer_record_DP;

import java.util.Scanner;

public class num2294 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        // start
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] DPT1 = new int[k+1];

        for (int i = 0; i < n; i++) {
            int coin = sc.nextInt();
            if (coin <= k){
                DPT1[coin] = 1;
            }
            for (int j = coin + 1; j <= k; j++) {
                if (DPT1[j-coin] != 0){
                    if (DPT1[j] != 0){
                        DPT1[j] = Math.min(DPT1[j], DPT1[j-coin] + 1);
                    }
                    else{
                        DPT1[j] = DPT1[j-coin] + 1;
                    }
                }
            }
        }
        if (DPT1[k] == 0) {
            System.out.println("-1");
        }
        else {
            System.out.println(DPT1[k]);
        }
    }
}
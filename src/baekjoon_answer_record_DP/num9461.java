package baekjoon_answer_record_DP;

import java.util.ArrayList;
import java.util.Scanner;

public class num9461 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        // start
        int table = sc.nextInt();
        for (int i = 0; i < table; i++) {
            int n = sc.nextInt();
            ArrayList<Long> DPT1 = new ArrayList<>();
            DPT1.add((long)0); // index 0
            DPT1.add((long)1); // index 1
            DPT1.add((long)1); // index 2
            DPT1.add((long)1); // index 3
            DPT1.add((long)2); // index 4
            DPT1.add((long)2); // index 5
            for (int j = 6; j <= n; j++) {
                DPT1.add(DPT1.get(j-1) + DPT1.get(j-5));
            }
            System.out.println(DPT1.get(n));
        }
    }
}

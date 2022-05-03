package algorithm_record;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LIS { // LIS
    public static void main(String[] args) {

        int n = 0;

        Scanner sc = new Scanner(System.in);

        System.out.print("ют╥б: ");

        n = sc.nextInt();

        ArrayList<Integer> DPT1 = new ArrayList<>();
        ArrayList<Integer> List1 = new ArrayList<>();

        // list input
        for (int i = 0; i < n; i++) {
            List1.add(sc.nextInt());
            DPT1.add(1);
        }

        // LIS DPT1
        Collections.reverse(List1);

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(List1.get(i) > List1.get(j)) {
                    DPT1.set(i,Math.max(DPT1.get(i), DPT1.get(j)+1));
                }
            }
        }

        // answer output
        System.out.println(n - Collections.max(DPT1));
    }
}


package baekjoon_answer_record_DP;

import java.util.ArrayList;
import java.util.Scanner;

public class MinimumCurrency { // 만들 수 있는 가장 적은 화폐 수 도출 * 없으면 -1
    public static void main(String[] args) {

        int n = 0;
        int money = 0;
        int mini = 0;

        Scanner sc = new Scanner(System.in);

        System.out.print("입력: ");

        n = sc.nextInt();
        money = sc.nextInt();


        ArrayList<Integer> DP1 = new ArrayList<Integer>();
        ArrayList<Integer> Currency = new ArrayList<Integer>();

        DP1.add(0);// index 0

        // list input
        for(int i = 0; i < n; i++) {
            Currency.add(sc.nextInt());
        }

        // start
        for(int i = 1; i<= money; i++) {
            mini = -1;
            for (int j : Currency) {
                if ( ((i - j) >= 0) && (DP1.get(i - j) != -1) ) {
                    if (mini == -1) {
                        mini = DP1.get(i - j) + 1;
                    }
                    else {
                        mini = Math.min( DP1.get(i - j) + 1, mini);
                    }
                }
            }
            DP1.add(mini);// index i
        }

        // answer output
        System.out.println(DP1.get(money));
    }
}
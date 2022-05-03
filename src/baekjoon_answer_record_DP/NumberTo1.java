package baekjoon_answer_record_DP;

import java.util.ArrayList;
import java.util.Scanner;
import java.math.*;

public class NumberTo1 { // n의 수를 1로 만드는 최소의 방법 /5, /3, /2, -1 사용
    public static void main(String[] args) {

        int n = 0;
        int mini = 0;

        ArrayList<Integer> DP1 = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);

        System.out.print("입력:");
        n = sc.nextInt();

        DP1.add(0);// index 0
        DP1.add(0);// index 1

        // start
        for(int i = 2; i< n+1; i++) {
            mini = DP1.get(i-1) + 1;
            if (i%5 == 0) {
                mini = Math.min( DP1.get(i/5) + 1, mini);
            }
            if (i%3 == 0) {
                mini = Math.min( DP1.get(i/3) + 1, mini);
            }
            if (i%2 == 0) {
                mini = Math.min( DP1.get(i/2) + 1, mini);
            }
            DP1.add(mini);// index i
        }

        // answer output
        System.out.println(DP1.get(n));
    }
}

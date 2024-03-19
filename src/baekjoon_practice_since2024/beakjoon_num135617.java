package baekjoon_practice_since2024;

import java.util.Scanner;

public class beakjoon_num135617 {
    static int[] count_fibo_0_at_n = new int[41];
    static int[] count_fibo_1_at_n = new int[41];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        count_fibo_0_at_n[0] = 1;
        count_fibo_1_at_n[1] = 1;

        int re_try = sc.nextInt();
        for (int i = 0; i < re_try; i++) {
            int n = sc.nextInt();
            fibo(n);
            System.out.println(count_fibo_0_at_n[n] + " " + count_fibo_1_at_n[n]);
        }
    }
    public static int fibo(int n ) {
        //System.out.println("now fibo(" + n + ")");
        if ( n > 0 && (count_fibo_0_at_n[n-1] == 0 && count_fibo_1_at_n[n-1] == 0)) { // fibo(n-1)함수를 진행하지 않았다면
            fibo(n-1);
        }
        if (n > 1 && (count_fibo_0_at_n[n-2] == 0 && count_fibo_1_at_n[n-2] == 0)) {// fibo(n-2)함수를 진행하지 않았다면
            fibo(n-2);
        }
        if (n > 1) { // n == 0, n == 1 일 때 수행하지 않음 why? index 범위가 벗어나기때문에 main()에서 미리 예외처리 완료
            count_fibo_0_at_n[n] = count_fibo_0_at_n[n-1] + count_fibo_0_at_n[n-2];
            count_fibo_1_at_n[n] = count_fibo_1_at_n[n-1] + count_fibo_1_at_n[n-2];
        }
        return 0;
    }
}

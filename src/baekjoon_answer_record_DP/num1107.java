package baekjoon_answer_record_DP;

import java.util.Scanner;

public class num1107 {
    static boolean[] brok;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        brok = new boolean[10];

        for(int i=0;i<M;i++){
            brok[sc.nextInt()]=true;
        }

        int val = Math.abs(N-100);
        for(int i=0;i<1000000;i++){
            int len =check(i);

            if(len>0)val=Math.min(Math.abs(N-i)+len,val);
        }
        System.out.println(val);
    }
    static int check(int n){
        if(n==0){
            if(brok[n]){
                return 0;
            }
            return 1;
        }
        int length = 0;
        while(n>0){
            if(brok[n%10]){
                return 0;
            }
            length++;
            n/=10;
        }
        return length;
    }

    /* 자작
    static int N_num;
    static String N;
    static int M;
    static boolean[] broken;
    static int minimum = 0;
    static int row;
    static int high;
    static int approximate_value = 0;
    static int reset = 0;
    public static void main(String[] args) { //
        Scanner sc = new Scanner(System.in);
        N_num = sc.nextInt();
        N = N_num + "";
        minimum = Math.abs(100 - N_num);
        M = sc.nextInt();
        broken = new boolean[10];
        for (int i = 0; i < M; i++) {
            broken[sc.nextInt()] = true;
        }
        if (M == 10) { System.out.println(Math.abs(minimum)); return; } // 즉시 종료
        row = 10;
        high = -1;
        for (int i = 0; i < 10; i++) { // row와 high 구분
            if (!broken[i]) { // 고장나지 않았다면
                if (i != 0) {
                    row = Math.min(i, row);
                }
                high = Math.max(i, high);
            }
        }
        for (int i = 0; i < N.length() + 1; i++) { // 윗 자리
            if (!broken[0] && i != 0){
                continue;
            }
            else {
                approximate_value += row * (int)Math.pow(10,N.length() - i);
            }
        }
        //System.out.println("high " + approximate_value);
        minimum = Math.min(minimum, N.length() + 1 + (approximate_value - N_num) );
        approximate_value = 0;
        if (1 < N.length()) { // 아랫 자리
            for (int i = 0; i < N.length() - 1; i++) {
                approximate_value += high * (int)Math.pow(10,N.length() - 2 - i);
            }
            minimum = Math.min(minimum, Math.abs(approximate_value - N_num) + N.length() - 1);
        }
        approximate_value = 0;
        for (int i = 0; i < N.length(); i++) {
            for (int j = 0; j < 10; j++) { // 같은 자리
                if (!broken[j]) {
                    if (j < N.charAt(i) - '0') {
                        approximate_value += j * (int)Math.pow(10,N.length() - i - 1);
                        for (int k = 1; k < N.length() - i; k++) { // 같은 자리
                            approximate_value += high * (int)Math.pow(10,N.length() - i - 1 - k);
                        }
                    }
                    else {
                        approximate_value += j * (int)Math.pow(10,N.length() - 1 - i);
                        if (!broken[0]) {
                            for (int k = 0; k < N.length() - 1 - i; k++) { // 같은 자리
                                approximate_value += 0 * (int)Math.pow(10,N.length() - 2 - i - k);
                            }
                        }
                        else {
                            for (int k = 0; k < N.length() - 1 - i; k++) { // 같은 자리
                                approximate_value += row * (int)Math.pow(10,N.length() - 2 - i - k);
                            }
                        }
                    }
                    //System.out.println("middle " + i + " " + j + " " + approximate_value);
                    minimum = Math.min(minimum, Math.abs(approximate_value - N_num) + N.length());
                    approximate_value = reset;
                }
            }
            if (!broken[N.charAt(i) - '0']) { // 고장나지 않았다면
                reset += (N.charAt(i) - '0') * (int)Math.pow(10,N.length() - 1 - i);
                approximate_value = reset;
            }
            else {
                break;
            }
        }
        System.out.println(minimum);
    }
     */
}

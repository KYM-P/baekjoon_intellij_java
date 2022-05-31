package baekjoon_practice_space;

import java.util.Scanner;

public class practice_space_2 {
    static int N_num;
    static String N;
    static int M;
    static boolean[] broken;
    static int count = 0;
    static int minimum = 0;
    static int row;
    static int high;
    static int approximate_value = 0;
    public static void main(String[] args) { // dp
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
        int c = 0;
        for (int i = 0; i < 10; i++) { // row와 high 구분
            if (!broken[i]) { // 고장나지 않았다면
                if (i != 0) {
                    row = Math.min(i, row);
                }
                high = Math.max(i, high);
            }
        }
        if (1 < N.length()) {
            int row_num = 0;
            for (int i = 2; i < N.length() + 1; i++) {
                row_num += high * (int)Math.pow(10,N.length()-i);
            }
            minimum = Math.min(minimum, Math.abs(row_num - N_num) + N.length() - 1);
        }
        for (int i = 0; i < N.length(); i++) { // 같은 자릿수에서 이동
            if (!broken[N.charAt(i) - '0']) { // 고장나지 않았다면
                count++;
                approximate_value += (N.charAt(i) - '0') * (int)Math.pow(10,N.length()-count);
                c = -1;
            }
            else {
                break;
            }
        }
        if (count == N.length()) {
            System.out.println(Math.min(minimum, count));
            return;
        }
        else {
            if (N.charAt(count) == '0' && count != 0) {
                count--;
                approximate_value -= (N.charAt(count) - '0') * (int)Math.pow(10,N.length()-count-1);
            }
            int sum = 0;
            for (int i = 0; i < N.length() - count + 1; i++) { // 윗 자리
                if (!broken[0] && i != 0){
                    c++;
                    continue;
                }
                else {
                    c++;
                    sum += row * (int)Math.pow(10,N.length() - count - i);
                }
            }
            System.out.println("high " + approximate_value + " " + sum + " " + c);
            minimum = Math.min(minimum, count + c + (sum - (N_num - approximate_value)) );
            sum = 0;
            c = 0;
            for (int i = 0; i < 10; i++) { // 같은 자리
                if (!broken[i]) {
                    if (i < N.charAt(count) - '0') {
                        sum += i * (int)Math.pow(10,N.length() - count - 1);
                        c++;
                        for (int j = 1; j < N.length() - count; j++) { // 같은 자리
                            sum += high * (int)Math.pow(10,N.length() - count - 1 - j);
                            c++;
                        }
                    }
                    else {
                        sum += i * (int)Math.pow(10,N.length() - count -1);
                        c++;
                        if (!broken[0]) {
                            for (int j = 1; j < N.length() - count; j++) { // 같은 자리
                                sum += 0 * (int)Math.pow(10,N.length() - count - 1 - j);
                                c++;
                            }
                        }
                        else {
                            for (int j = 1; j < N.length() - count; j++) { // 같은 자리
                                sum += row * (int)Math.pow(10,N.length() - count - 1 - j);
                                c++;
                            }
                        }
                    }
                    System.out.println("middle " + i + " " + sum);
                    minimum = Math.min(minimum, count + c + Math.abs(sum - (N_num - approximate_value)));
                    sum = 0;
                    c = 0;
                }
            }
        }
        System.out.println(minimum);
    }
}

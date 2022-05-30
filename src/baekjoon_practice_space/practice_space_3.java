package baekjoon_practice_space;

import java.util.Scanner;
public class practice_space_3 {
    static int N_num;
    static String N;
    static int M;
    static boolean[] broken;
    static int count = 0;
    static int first = 0;
    static int row;
    static int high;
    static int approximate_value = 0;
    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);
        N_num = sc.nextInt();
        N = N_num + "";
        M = sc.nextInt();
        broken = new boolean[10];
        for (int i = 0; i < M; i++) {
            broken[sc.nextInt()] = true;
        }
        if (M == 10) { System.out.println(Math.abs(100 - N_num)); return; } // 즉시 종료
        row = 10;
        high = -1;
        for (int i = 0; i < 10; i++) { // row와 high 구분
            if (!broken[i]) { // 고장나지 않았다면
                row = Math.min(i, row);
                high = Math.max(i, high);
            }
        }
        int high_num = 0;
        for (int i = 0; i < N.length() + 1; i++) {
            high_num += row * (int)Math.pow(10,N.length()-i);
        }
        first = Math.min(Math.abs(100 - N_num), Math.abs(high_num - N_num) + N.length() + 1);
        if (1 < N.length()) {
            int row_num = 0;
            for (int i = 2; i < N.length() + 1; i++) {
                row_num += high * (int)Math.pow(10,N.length()-i);
            }
            first = Math.min(first, Math.abs(row_num - N_num) + N.length() - 1);
        }
        for (int i = 0; i < N.length(); i++) { // 같은 자릿수에서 이동
            if (!broken[N.charAt(i) - '0']) { // 고장나지 않았다면
                count++;
                approximate_value += (N.charAt(i) - '0') * (int)Math.pow(10,N.length()-count);
            }
            else {
                break;
            }
        }
        if (count == N.length()) {
            System.out.println(Math.min(first, count));
            return;
        }
        else {
            for (int i = 1; i < 11 ; i++) {
                if (N.charAt(count) - '0' + i < 10 && !broken[N.charAt(count) - '0' + i]) { // 기존 채널보다 큰 채널로 이동할 경우
                    approximate_value += (N.charAt(count) - '0' + i) * (int)Math.pow(10,N.length()-(count+1));
                    count++;
                    for (int k = count; k < N.length(); k++) {
                        count++;
                        approximate_value += (row) * (int)Math.pow(10,N.length()-count);
                    }
                    break;
                }
                else if (N.charAt(count) - '0' - i > -1 && !broken[N.charAt(count) - '0' - i]) { // 기존 채널보다 작은 채널로 이동할 경우
                    approximate_value += (N.charAt(count) - '0' - i) * (int)Math.pow(10,N.length()-(count+1));
                    count++;
                    for (int k = count; k < N.length(); k++) {
                        count++;
                        approximate_value += (high) * (int)Math.pow(10,N.length()-count);
                    }
                    break;
                }
            }
        }
        System.out.println(approximate_value + " " + count);
        count += Math.abs(approximate_value - N_num);
        System.out.println(Math.min(first, count));
    }
}

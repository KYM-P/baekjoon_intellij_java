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
        if (M == 10) { System.out.println(Math.abs(minimum)); return; } // ��� ����
        row = 10;
        high = -1;
        int c = 0;
        for (int i = 0; i < 10; i++) { // row�� high ����
            if (!broken[i]) { // ���峪�� �ʾҴٸ�
                if (i != 0) {
                    row = Math.min(i, row);
                }
                high = Math.max(i, high);
            }
        }
        for (int i = 0; i < N.length(); i++) { // ���� �ڸ������� �̵�
            if (!broken[N.charAt(i) - '0']) { // ���峪�� �ʾҴٸ�
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
            int sum = 0;
            for (int i = 0; i < N.length() - count + 1; i++) { // �� �ڸ�
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
            for (int i = 0; i < 10; i++) { // ���� �ڸ�
                if (!broken[i]) {
                    if (i < N.charAt(count)) {
                        sum += i * (int)Math.pow(10,N.length() - count - 1);
                        c++;
                        for (int j = 1; j < N.length() - count; j++) { // ���� �ڸ�
                            sum += high * (int)Math.pow(10,N.length() - count - 1 - j);
                            c++;
                        }
                    }
                    else {
                        sum += i * (int)Math.pow(10,N.length() - count -1);
                        c++;
                        for (int j = 1; j < N.length() - count; j++) { // ���� �ڸ�
                            sum += row * (int)Math.pow(10,N.length() - count - 1 - j);
                            c++;
                        }
                    }
                    minimum = Math.min(minimum, count + c + Math.abs(sum - (N_num - approximate_value)));
                }
            }
            sum = 0;
            c = 0;
            if (1 < N.length() - count) { // �Ʒ� �ڸ�
                for (int i = 0; i < N.length() - count - 1; i++) {
                    sum += high * (int)Math.pow(10,N.length() - count - 2 -i);
                    c++;
                }
                System.out.println("row " + approximate_value + " " + sum + " " + c);
                minimum = Math.min(minimum, count + c + Math.abs(sum - (N_num - approximate_value)));
            }
        }
        System.out.println(minimum);
    }
}

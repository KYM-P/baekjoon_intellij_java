package baekjoon_practice_space;

import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[][] menu;
    static int min = Integer.MAX_VALUE;
    static int[] list;
    static int[] minlist;
    static Integer[][] DP;
    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);

        // list input
        N = sc.nextInt();
        M = sc.nextInt();
        menu = new int[M+1][2];
        for (int i = 1; i <= M; i++) {
            menu[i][0] = sc.nextInt();
            menu[i][1] = sc.nextInt();
        }
        list = new int[M+1];
        minlist = new int[M+1];
        // start
        DP = new Integer[M+1][3];
        start(0,0,1,0);
        System.out.println(min);
        for (int i = 1; i <= M; i++) {
            System.out.println(minlist[i]);
        }
    }
    public static void start(int point1, int point2, int next, int value) {
        if (next == M+1) {
            if (min > value) {
                min = value;
                for (int i = 1; i <= M; i++) {
                    minlist[i] = list[i];
                }
            }
            return;
        }
        if (DP[next][0] == null || DP[next][1] == null) {
            DP[next][0] = next;
        }
        else {
            list[next] = 1;
            start();
            list[next] = 2;
            start();
            list[next] = 0;
        }
        return;
    }
}

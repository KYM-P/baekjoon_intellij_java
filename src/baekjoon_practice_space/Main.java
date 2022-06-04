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
        menu[0][0] = 1;
        menu[0][1] = 1;
        for (int i = 1; i <= M; i++) {
            menu[i][0] = sc.nextInt();
            menu[i][1] = sc.nextInt();
        }
        list = new int[M+1];
        minlist = new int[M+1];
        // start
        DP = new Integer[M+1][M+1];
        for (int i = 1; i <= M; i++) {
            DP[i][0] = DP[i-1][0] + Math.abs(menu[i-1][0] - menu[i][0]) + Math.abs(menu[i-1][1] - menu[i][1]);
            DP[0][i] = DP[0][i-1] + Math.abs(menu[i-1][0] - menu[i][0]) + Math.abs(menu[i-1][1] - menu[i][1]);
            for (int j = 1; j < i; j++) {
                //DP[i][j] =
            }
        }

        System.out.println(min);
        for (int i = 1; i <= M; i++) {
            System.out.println(minlist[i]);
        }
    }
}

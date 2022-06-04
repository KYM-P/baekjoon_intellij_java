package baekjoon_practice_space;

import java.util.Scanner;

public class practice_space_1  {
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
        start(0,0,0,0);
        System.out.println(min);
        for (int i = 1; i <= M; i++) {
            System.out.println(minlist[i]);
        }
    }
    public static void start(int point1, int point2, int next, int value) {
        // dp 갱신
        if (DP[point1][point2] != null && DP[point1][point2] > value) {
            DP[point1][point2] = value;
        }
        else if (DP[point1][point2] != null && DP[point1][point2] <= value) {
            return;
        }
        else if (DP[point1][point2] == null) {
            DP[point1][point2] = value;
        }
        // 종료 조건
        if (next == M) {
            if (min > value) {
                min = value;
                for (int i = 1; i <= M; i++) {
                    minlist[i] = list[i];
                }
            }
            return;
        }
        // 재귀
        list[next+1] = 1;
        start(next+1, point2, next+1, value + Math.abs(menu[point1][0] - menu[next+1][0]) + Math.abs(menu[point1][1] - menu[next+1][1]));
        list[next+1] = 2;
        if (point2 == 0) {
            start(point1, next+1, next+1,value + Math.abs(N - menu[next+1][0]) + Math.abs(N - menu[next+1][1]));
        }
        else {
            start(point1, next+1, next+1, value + Math.abs(menu[point2][0] - menu[next+1][0]) + Math.abs(menu[point2][1] - menu[next+1][1]));
        }
        list[next+1] = 0;
        return;
    }
}

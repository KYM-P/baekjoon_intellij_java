package baekjoon_practice_space;

import java.util.Scanner;

public class practice_space_1  {
    static int N;
    static int M;
    static int[][] menu;
    static int min = Integer.MAX_VALUE;
    static int[] list;
    static int[] minlist;
    static int next;
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
        list = new int[M];
        minlist = new int[M];
        // start
        DP = new Integer[M+1][M+1];
        DP[0][0] = 0;
        next = 0;
        start(0,0);
        //System.out.println("---");
        System.out.println(min);
        for (int i = 0; i < M; i++) {
            System.out.println(minlist[i]);
        }
    }
    public static void start(int point1, int point2) {
        // 종료 조건
        if (next == M){
            if (min > DP[point1][point2]) { // 최단기록 갱신시
                min = DP[point1][point2];
                for (int i = 0; i < M; i++) { // 최단기록 리스트
                    minlist[i] = list[i];
                }
            }
            return;
        }
        // dp 갱신 + 재귀
        list[next] = 1;
        next++;
        if (point1 == 0) {
            menu[point1][0] = 1;
            menu[point1][1] = 1;
        }
        if (DP[next][point2] != null) {
            if (DP[next][point2] > DP[point1][point2] + Math.abs(menu[point1][0] - menu[next][0]) + Math.abs(menu[point1][1] - menu[next][1])) {
                DP[next][point2] = DP[point1][point2] + Math.abs(menu[point1][0] - menu[next][0]) + Math.abs(menu[point1][1] - menu[next][1]);
            }
            else {
                next--;
                return;
            }
        }
        else {
            DP[next][point2] = DP[point1][point2] + Math.abs(menu[point1][0] - menu[next][0]) + Math.abs(menu[point1][1] - menu[next][1]);
        }
        //System.out.println(next + " " + point2 + " " + DP[next][point2]);
        start(next,point2);
        next--;
        list[next] = 2;
        next++;
        if (point2 == 0) {
            menu[point2][0] = N;
            menu[point2][1] = N;
        }
        if (DP[point1][next] != null) {
            if (DP[point1][next] > DP[point1][point2] + Math.abs(menu[point2][0] - menu[next][0]) + Math.abs(menu[point2][1] - menu[next][1])) {
                DP[point1][next] = DP[point1][point2] + Math.abs(menu[point2][0] - menu[next][0]) + Math.abs(menu[point2][1] - menu[next][1]);
            }
            else {
                next--;
                return;
            }
        }
        else {
            DP[point1][next] = DP[point1][point2] + Math.abs(menu[point2][0] - menu[next][0]) + Math.abs(menu[point2][1] - menu[next][1]);
        }
        //System.out.println(point1 + " " + next + " " + DP[point1][next]);
        start(point1,next);
        next--;
    }
}

package baekjoon_practice_space;

import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[][] menu;
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
        // start
        DP = new Integer[M+1][M+1]; // 해당 상황에서 마지막 까지의 최단 값
        System.out.println(start(0,0));
        path(0,0);
    }
    public static int start(int point1, int point2) {
        int next = Math.max(point1, point2) + 1;
        if (next == M + 1) {
            return 0;
        }
        if(DP[point1][point2] != null) {
            return DP[point1][point2];
        }
        System.out.println(point1 + " " + point2);
        DP[point1][point2] = Math.min(start(next,point2) + Math.abs((point1==0?1:menu[point1][0]) - menu[next][0]) + Math.abs((point1==0?1:menu[point1][1]) - menu[next][1]), start(point1,next) + Math.abs((point2==0?N:menu[point2][0]) - menu[next][0]) + Math.abs((point2==0?N:menu[point2][1]) - menu[next][1]));
        return DP[point1][point2];
    }
    public static void path(int point1, int point2) {
        int next = Math.max(point1, point2) + 1;
        if (next == M + 1) {
            return;
        }
        if (Math.abs((point1==0?1:menu[point1][0]) - menu[next][0]) + Math.abs((point1==0?1:menu[point1][1]) - menu[next][1]) + DP[next][point2] < Math.abs((point2==0?N:menu[point2][0]) - menu[next][0]) + Math.abs((point2==0?N:menu[point2][1]) - menu[next][1]) + DP[point1][next]) {
            System.out.println(1);
            path(next, point2);
        }
        else {
            System.out.println(2);
            path(point1, next);
        }
    }
}

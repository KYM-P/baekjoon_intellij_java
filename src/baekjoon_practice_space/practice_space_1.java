package baekjoon_practice_space;

import java.util.Scanner;

public class practice_space_1  {
    static int N;
    static int M;
    static int[][] menu;
    static int min = Integer.MAX_VALUE;
    static int[] list;
    static int[] minlist;
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
        start(1,1, N, N, 1, 0);
        System.out.println(min);
        for (int i = 1; i <= M; i++) {
            System.out.println(minlist[i]);
        }
    }
    public static void start(int x1, int y1, int x2, int y2, int next, int value) {
        if (next == M+1) {
            if (min > value) {
                min = value;
                for (int i = 1; i <= M; i++) {
                    minlist[i] = list[i];
                }
            }
            return;
        }
        else {
            list[next] = 1;
            start(menu[next][0],menu[next][1],x2,y2,next+1,value + Math.abs(menu[next][0] - x1)+Math.abs(menu[next][1] - y1));
            list[next] = 2;
            start(x1,y1,menu[next][0],menu[next][1],next+1,value + Math.abs(menu[next][0] - x2)+Math.abs(menu[next][1] - y2));
            list[next] = 0;
        }
        return;
    }
}

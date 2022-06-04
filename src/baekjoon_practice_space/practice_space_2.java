package baekjoon_practice_space;

import java.util.ArrayList;
import java.util.Scanner;

public class practice_space_2 {
    static int N;
    static int M;
    static int[][] menu;
    static int min = Integer.MAX_VALUE;
    static ArrayList<Integer> list = new ArrayList<>();
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
        minlist = new int[M];
        // start
        DP = new Integer[M+1][M+1];
        DP[0][0] = 0;
        start(0,0);
        System.out.println(min);
        for (int i = 0; i < M; i++) {
            System.out.println(minlist[i]);
        }
    }
    public static void start(int point1, int point2) {
        // 종료 조건
        if (list.size() == M){
            if (min > DP[point1][point2]) { // 최단기록 갱신시
                min = DP[point1][point2];
                for (int i = 0; i < M; i++) { // 최단기록 리스트
                   minlist[i] = list.get(i);
                }
            }
            return;
        }
        // dp 갱신 + 재귀
        list.add(1);
        if (point1 == 0) {
            menu[point1][0] = 1;
            menu[point1][1] = 1;
        }
        if (DP[list.size()][point2] != null) {
            if (DP[list.size()][point2] > DP[point1][point2] + Math.abs(menu[point1][0] - menu[list.size()][0]) + Math.abs(menu[point1][1] - menu[list.size()][1])) {
                DP[list.size()][point2] = DP[point1][point2] + Math.abs(menu[point1][0] - menu[list.size()][0]) + Math.abs(menu[point1][1] - menu[list.size()][1]);
            }
            else {
                return;
            }
        }
        else {
            DP[list.size()][point2] = DP[point1][point2] + Math.abs(menu[point1][0] - menu[list.size()][0]) + Math.abs(menu[point1][1] - menu[list.size()][1]);
        }
        start(list.size(),point2);
        list.remove(list.size()-1);
        list.add(2);
        if (point2 == 0) {
            menu[point2][0] = N;
            menu[point2][1] = N;
        }
        if (DP[list.size()][point2] != null) {
            if (DP[list.size()][point2] > DP[point1][point2] + Math.abs(menu[point2][0] - menu[list.size()][0]) + Math.abs(menu[point2][1] - menu[list.size()][1])) {
                DP[list.size()][point2] = DP[point1][point2] + Math.abs(menu[point2][0] - menu[list.size()][0]) + Math.abs(menu[point2][1] - menu[list.size()][1]);
            }
            else {
                return;
            }
        }
        else {
            DP[list.size()][point2] = DP[point1][point2] + Math.abs(menu[point1][0] - menu[list.size()][0]) + Math.abs(menu[point1][1] - menu[list.size()][1]);
        }
        start(list.size(),point2);
        list.remove(list.size()-1);
    }
}

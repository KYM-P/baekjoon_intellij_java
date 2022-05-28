package baekjoon_practice_space;

import java.util.Scanner;

public class practice_space_1  {
    static int[] b;
    static int n, ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();

        int open1 = sc.nextInt();
        int open2 = sc.nextInt();

        n = sc.nextInt();
        b = new int[n];
        for(int i=0; i<n; i++) {
            b[i] = sc.nextInt();
        }
        go(open1, open2, 0, 0);
        System.out.println(ans);
    }
    static void go(int open1, int open2, int depth, int move) {
        if (depth == n) {
            if (move < ans) ans = move;
            return;
        }
        int tmp1 = Math.abs(open1 - b[depth]);
        int tmp2 = Math.abs(open2 - b[depth]);
        go(open1, b[depth], depth + 1, move + tmp2); //open2를 움직이는 경우
        go(b[depth], open2, depth + 1, move + tmp1); //open1을 움직이는 경우
    }
}

package baekjoon_practice_space;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int[][] table = new int[500][500];
    static int[][] DP = new int[500][500];
    static int N;
    static int M;
    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // list input
        N = sc.nextInt(); // 세로
        M = sc.nextInt(); // 가로

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                table[i][j] = sc.nextInt();
            }
        }

        // start
        Stack<int[]> s = new Stack<>();
        dfs(0,0 , s);
        System.out.println(result);

        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < M; j++) {
                System.out.print(DP[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
    public static void dfs (int x, int y, Stack<int[]> s) {
        int height = table[y][x];
        if (x == M-1 && y == N-1) {
            st_to_DP(s);
            result++;
            s.pop();
            return;
        }
        if (x > 0 && table[y][x - 1] < height) { // left
            if (DP[y][x-1] > 0) {

            }
            else {
                s.push(new int[]{x-1,y});
                dfs(x-1, y, s);
            }
        }
        if (y > 0 && table[y - 1][x] < height) { // up
            if (DP[y - 1][x] > 0) {
                st_to_DP(s);
                result += DP[y - 1][x];
            }
            else {
                s.push(new int[]{x,y-1});
                dfs(x, y-1, s);
            }
        }
        if (x < M - 1 && table[y][x + 1] < height) { // right
            if (DP[y][x+1] > 0) {
                st_to_DP(s);
                result += DP[y][x+1];
            }
            else {
                s.push(new int[]{x+1,y});
                dfs(x+1, y, s);
            }
        }
        if (y < N - 1 && table[y + 1][x] < height) { // down
            if (DP[y+1][x] > 0) {
                st_to_DP(s);
                result += DP[y+1][x];
            }
            else {
                s.push(new int[]{x,y+1});
                dfs(x, y+1, s);
            }
        }
        if (!s.isEmpty()) {
            s.pop();
        }
        return;
    }

    public static void st_to_DP (Stack<int[]> s) {
        for (int i = 0; i < s.size(); i++) {
            int x = s.get(i)[0];
            int y = s.get(i)[1];
            DP[y][x] += 1;
        }
    }
}

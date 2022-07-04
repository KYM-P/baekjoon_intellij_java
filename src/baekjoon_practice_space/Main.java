package baekjoon_practice_space;


import java.util.Scanner;

public class Main {
    static int N;
    static String table;
    static String goal;
    static int[][] UP;
    static int[][] Down;
    static int[] DP;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        // list input
        N = sc.nextInt();
        sc.nextLine();
        table = sc.nextLine();
        goal = sc.nextLine();
        UP = new int[10][10];
        Down = new int[10][10];
        for (int i = 0; i < 10; i ++) { // UP, Down 배열 작성
            for (int j = 0; j < 10; j++) {
                if (i > j) {
                    Down[i][j] = i - j;
                    UP[i][j] = 10 - Down[i][j];
                }
                else if (i < j) {
                    UP[i][j] = j - i;
                    Down[i][j] = 10 - UP[i][j];
                }
                else {
                    UP[i][j] = 0;
                    Down[i][j] = 0;
                }
            }
        }
        // start
        DP = new int[N+1];
        DP[N] = 1000000000;
        go(table.charAt(0) - '0', table.charAt(1) - '0', table.charAt(2) - '0', 0, 0);
        System.out.println(DP[N]);

    }
    public static int up(int a){
        if (a >= 10) {
            return a-10;
        }
        return a;
    }
    public static int down(int a){
        if (a < 0) {
            return a+10;
        }
        return a;
    }

    public static void go (int a, int b, int c, int main_index, int count) {
        if (main_index == N-1) {
            DP[N] = Math.min(DP[N],count);
            return;
        }
        if (UP[a][table.charAt(main_index) - '0'] <= Down[a][table.charAt(main_index) - '0']) {
            if (UP[a][table.charAt(main_index) - '0'] > 3) {
                go(up(a+3), up(b+3), up(c+3),main_index,count+1);
                go(up(a+3), up(b+3), c,main_index,count+1);
                go(up(a+3), b, c,main_index,count+1);
                return;
            }
            else {
                int k = UP[a][table.charAt(main_index) - '0'];
                if (main_index >= N-3) {
                    go(up(b+k), up(c+k), 0,main_index+1,count+1);
                    go(up(b+k), c, 0,main_index+1,count+1);
                    go(b, c, 0,main_index+1,count+1);
                }
                else {
                    go(up(b+k), up(c+k), table.charAt(main_index+3) - '0',main_index+1,count+1);
                    go(up(b+k), c, table.charAt(main_index+3) - '0',main_index+1,count+1);
                    go(b, c, table.charAt(main_index+3) - '0',main_index+1,count+1);
                }
                return;
            }
        }
        else {
            if (Down[a][table.charAt(main_index) - '0'] > 3) {
                go(down(a-3), down(b-3), down(c-3),main_index,count+1);
                go(down(a-3), down(b-3), c,main_index,count+1);
                go(down(a-3), b, c,main_index,count+1);
                return;
            }
            else {
                int k = Down[a][table.charAt(main_index) - '0'];
                if (main_index >= N-3) {
                    go(down(b-k), down(c-k), 0,main_index+1,count+1);
                    go(down(b-k), c, 0,main_index+1,count+1);
                    go(b, c, 0,main_index+1,count+1);
                }
                else {
                    go(down(b-k), down(c-k), table.charAt(main_index+3) - '0',main_index+1,count+1);
                    go(down(b-k), c, table.charAt(main_index+3) - '0',main_index+1,count+1);
                    go(b, c, table.charAt(main_index+3) - '0',main_index+1,count+1);
                }
                return;
            }
        }
    }
}

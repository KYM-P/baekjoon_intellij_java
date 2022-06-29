package baekjoon_practice_space;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class practice_space_2 {

    static int N;
    static String table;
    static String goal;
    static int[][] UP;
    static int[][] Down;
    static int[] DP;

    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);

        // list input
        N = sc.nextInt();
        sc.nextLine();
        table = sc.nextLine();
        goal = sc.nextLine();

        // start
        UP = new int[N + 1][10];
        Down = new int[N + 1][10];
        DP = new int[N + 1];
        //System.out.println(table + " " + goal);
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > goal.charAt(i-1)) {

                }
                else if (j < goal.charAt(i-1)) {

                }
                else { // table-N == goal_n
                    UP[i][j] = 0;
                    Down[i][j] = 0;
                }
            }
            if (i > 1) {

            }
            if (i > 2) {

            }
        }

    }

    public static int first (int a) {
        int count = 0;
        count += a/3 + ((a%3 > 0)?1:0);
        return count;
    }
    public static int second (int a, int b, int lastindex) {
        int count = 0;

        return count;
    }
    public static int third (int a, int b, int c, int lastindex, boolean up_t) {
        int count = 0;
        int up = 0;
        int down = 0;
        int main = 0;
        int m_index = 0;
        if (a == b && b == c) {
            count += a/3 + ((a%3 > 0)?1:0);
            return count;

        }
        else if (a == b) {
            count += a/3 + ((a%3 > 0)?1:0);
            main = a;
            m_index = 0;
        }
        else if (b == c) {
            count += b/3 + ((b%3 > 0)?1:0);
            main = b;
            m_index = 1;
        }
        else if (c == a) {
            count += c/3 + ((c%3 > 0)?1:0);
            main = c;
            m_index = 2;
        }
        else {
            count += a/3 + ((a%3 > 0)?1:0);
        }
        // if ~ else if
        if (up_t) {
            up = (table.charAt(lastindex - m_index) - '0') + main;
            up = (up>9)?up-10:up;
            return count + Math.min(first(up_size(up ,goal.charAt(lastindex - m_index) - '0')), first(down_size(up ,goal.charAt(lastindex - m_index) - '0')));
        }
        else {
            down = (table.charAt(lastindex - m_index) - '0') - main;
            down = (down<0)?down+10:down;
            return count + Math.min(first(up_size(down ,goal.charAt(lastindex - m_index) - '0')), first(down_size(down ,goal.charAt(lastindex - m_index) - '0')));
        }
    }
}

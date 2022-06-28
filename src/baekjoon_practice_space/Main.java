package baekjoon_practice_space;


import java.util.Scanner;

public class Main {
    static int N;
    static String table;
    static String goal;
    static int[] UP;
    static int[] Down;
    static int[] DP;

    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);

        // list input
        N = sc.nextInt();
        sc.nextLine();
        table = sc.nextLine();
        goal = sc.nextLine();

        // start
        UP = new int[N + 1];
        Down = new int[N + 1];
        DP = new int[N + 1];
        //System.out.println(table + " " + goal);
        for (int i = 1; i <= N; i++) {

            if (i > 1) {

            }
            if (i > 2) {

            }
        }

    }
    public static int up_size(){

    }
    public static int first (int a, int lastindex) {
        int count = 0;
        return count;
    }
    public static int second (int a, int b, int lastindex) {
        int count = 0;

        return count;
    }
    public static int third (int a, int b, int c, int lastindex) {
        int count = 0;
        int up = 0;
        int down = 0;
        if (a == b && b == c) {
            count += a/3 + ((a%3 > 0)?1:0);
            return count;

        }
        else if (a == b) {
            count += a/3 + ((a%3 > 0)?1:0);
            return count + Math.min(first(table.charAt(lastindex), lastindex), first(c, lastindex));
        }
        else if (b == c) {
            count += b/3 + ((b%3 > 0)?1:0);
            return count + + first(a, lastindex - 2);
        }
        else if (c == a) {
            count += c/3 + ((c%3 > 0)?1:0);
            return count + + first(b, lastindex - 1);
        }
        else {
            count += a/3 + ((a%3 > 0)?1:0);
        }

        return count;
    }
}

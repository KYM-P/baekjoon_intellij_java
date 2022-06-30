package baekjoon_practice_space;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class practice_space_2 {
    /*

    static int N;
    static String table;
    static String goal;
    static Integer[][] UP;
    static Integer[][] Down;
    static int[] DP;

    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);

        // list input
        N = sc.nextInt();
        sc.nextLine();
        table = sc.nextLine();
        goal = sc.nextLine();

        // start
        UP = new Integer[10][10];
        Down = new Integer[10][10];
        DP = new int[N + 1];
        //System.out.println(table + " " + goal);
        for (int i = 1; i <= N; i++) {

            if (i > 1) {

            }
            if (i > 2) {

            }
        }

    }
    public static int up_size(int table_n,int goal_n){
        if (table_n > goal_n) {
            return (10 - table_n) + goal_n;
        }
        else if (table_n < goal_n) {
            return goal_n - table_n;
        }
        else { // table-N == goal_n
            return  0;
        }
    }
    public static int down_size(int table_n,int goal_n){
        if (table_n > goal_n) {
            return goal_n - table_n;
        }
        else if (table_n < goal_n) {
            return (10 - table_n) + goal_n;
        }
        else { // table-N == goal_n
            return  0;
        }
    }
    public static int first (int a) {
        int count = 0;
        count += a/3 + ((a%3 > 0)?1:0);
        return count;
    }
    public static int second (int a, int b, int lastindex, boolean up_t) {
        int count = 0;
        int del;
        int main = 0;
        int not_correct_index = 0;
        if (a > b) {
            count += b/3 + ((b%3 > 0)?1:0);
            main = b;
            not_correct_index = lastindex - 0;
        }
        else if (a < b) {
            count += a/3 + ((a%3 > 0)?1:0);
            main = a;
            not_correct_index = lastindex - 1;
        }
        else { // a == b
            count += a/3 + ((a%3 > 0)?1:0);
            return count;
        }
        if (up_t) {
            del = (table.charAt(not_correct_index) - '0') + main;
            del = (del>9)?del-10:del;
        }
        else {
            del = (table.charAt(not_correct_index) - '0') - main;
            del = (del<0)?del+10:del;
        }
        if (UP[goal.charAt(not_correct_index) - '0'][del] == null){
            memo(goal.charAt(not_correct_index) - '0',del);
        }
        return count + Math.min(first(UP[goal.charAt(not_correct_index) - '0'][del]), first(Down[goal.charAt(not_correct_index) - '0'][del]));
    }
    public static int third (int a, int b, int c, int lastindex, boolean up_t) {
        int count = 0;
        int del;
        int main = 0;
        int not_correct_index = 0;
        if (a == b && b == c) {
            count += a/3 + ((a%3 > 0)?1:0);
            return count;

        }
        else if (a == b) {
            count += a/3 + ((a%3 > 0)?1:0);
            main = a;
            not_correct_index = lastindex - 2;
        }
        else if (b == c) {
            count += b/3 + ((b%3 > 0)?1:0);
            main = b;
            not_correct_index = lastindex - 0;
        }
        else if (c == a) {
            count += c/3 + ((c%3 > 0)?1:0);
            main = c;
            not_correct_index = lastindex - 1;
        }
        else {
            int minimum = Math.min(Math.min(a,b),c);
            if (minimum == a) {
                count += a/3 + ((a%3 > 0)?1:0);
                if (up_t) {
                    return count + Math.min(second(UP[goal.charAt(lastindex - 1) - '0'][b-a], UP[goal.charAt(lastindex - 2) - '0'][c-a], lastindex - 1, true) ,second(Down[goal.charAt(lastindex - 1) - '0'][b-a], Down[goal.charAt(lastindex - 2) - '0'][c-a], lastindex - 1, false));
                }
                else {
                    return count + Math.min(second(UP[goal.charAt(lastindex - 1) - '0'][b-a], UP[goal.charAt(lastindex - 2) - '0'][c-a], lastindex - 1, true) ,second(Down[goal.charAt(lastindex - 1) - '0'][b-a], Down[goal.charAt(lastindex - 2) - '0'][c-a], lastindex - 1, false));
                }
            }
            else if (minimum == c) {
                count += c/3 + ((c%3 > 0)?1:0);
            }
            else {
            }
        }
        // if ~ else if
        if (up_t) {
            del = (table.charAt(not_correct_index) - '0') + main;
            del = (del>9)?del-10:del;
        }
        else {
            del = (table.charAt(not_correct_index) - '0') - main;
            del = (del<0)?del+10:del;
        }
        if (UP[goal.charAt(not_correct_index) - '0'][del] == null){
            memo(goal.charAt(not_correct_index) - '0',del);
        }
        return count + Math.min(first(UP[goal.charAt(not_correct_index) - '0'][del]), first(Down[goal.charAt(not_correct_index) - '0'][del]));
    }
    public static void memo (int a, int b) {
        UP[a][b] = up_size(a,b);
        UP[b][a] = UP[a][b];
        Down[a][b] = down_size(a,b);
        Down[b][a] = Down[a][b];
    }

     */
}

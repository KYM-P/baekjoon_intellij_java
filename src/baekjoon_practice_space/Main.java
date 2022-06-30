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
                    UP[i][j] = i - j;
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
        for (int i = 1; i <= N; i++) {
            DP[i] = one(table.charAt(i-1) - '0', i-1);
            if (i > 1) {
                DP[i] = Math.min(DP[i], two(table.charAt(i-2) - '0',table.charAt(i-1) - '0', i-1));
            }
            if (i > 2) {
                DP[i] = Math.min(DP[i], three(table.charAt(i-3) - '0',table.charAt(i-2) - '0',table.charAt(i-1) - '0', i-1));
            }
        }
        System.out.println(DP[N]);
    }
    public static int counting(int a) {
        return a/3 + ((a%3 > 0)?1:0);
    }
    public static int one(int first_value,int lastindex) {
        int first_goal = goal.charAt(lastindex) - '0';
        int minimum = Math.min(UP[first_value][first_goal],Down[first_value][first_goal]);
        return counting(minimum);
    }
    public static int two(int first_value,int second_value ,int lastindex) {
        int first_goal = goal.charAt(lastindex-1) - '0';
        int second_goal = goal.charAt(lastindex) - '0';
        int up_count;
        int down_count;
        if (UP[first_value][first_goal] == UP[second_value][second_goal]) { // 조기 종료
            return one(second_value, lastindex);
        }
        else { // 단축 가능
            // up
            int value_1 = 0;
            if (UP[first_value][first_goal] < UP[second_value][second_goal]) {
                value_1 = (UP[first_value][first_goal] + second_value);
                value_1 = value_1>10?10-value_1:value_1;
                up_count = counting(UP[first_value][first_goal]) + one(value_1, lastindex);
            }
            else {
                value_1 = (UP[second_value][second_goal] + first_value);
                value_1 = value_1>10?10-value_1:value_1;
                up_count = counting(UP[second_value][second_goal]) + one(value_1, lastindex-1);
            }
            // down
            if (Down[first_value][first_goal] < Down[second_value][second_goal]) {
                value_1 = (second_value - Down[first_value][first_goal]);
                value_1 = value_1<0?value_1+10:value_1;
                down_count = counting(Down[first_value][first_goal]) + one(value_1, lastindex);
            }
            else {
                value_1 = (first_value - Down[second_value][second_goal]);
                value_1 = value_1<0?value_1+10:value_1;
                down_count = counting(Down[second_value][second_goal]) + one(value_1, lastindex-1);
            }
            if (up_count <= down_count){
                return up_count;
            }
            else{
                return  down_count;
            }
        }
    }
    public static int three(int first_value,int second_value ,int third_value ,int lastindex) {
        int first_goal = goal.charAt(lastindex-2) - '0';
        int second_goal = goal.charAt(lastindex-1) - '0';
        int third_goal = goal.charAt(lastindex) - '0';
        int up_count;
        int down_count;
        if (UP[first_value][first_goal] == UP[second_value][second_goal] && UP[second_value][second_goal] == UP[third_value][third_goal]) { // 조기 종료
            return one(third_value,lastindex);
        }
        if (UP[first_value][first_goal] == UP[second_value][second_goal]) {
            return two(second_value, third_value, lastindex);
        }
        else if (UP[second_value][second_goal] == UP[third_value][third_goal]) {
            return two(first_value, second_value, lastindex-1);
        }
        else if (UP[third_value][third_goal] == UP[first_value][first_goal]) {
            // up
            int value_1 = 0;
            if (UP[third_value][third_goal] < Down[third_value][third_goal]) {
                value_1 = UP[third_value][third_goal] + second_value;
                value_1 = value_1>10?10-value_1:value_1;
                return counting(UP[third_value][third_goal]) + one(value_1, lastindex-1);
            }
            // down
            else {
                value_1 = second_value - Down[third_value][third_goal];
                value_1 = value_1<0?value_1+10:value_1;
                return counting(Down[third_value][third_goal]) + one(value_1, lastindex-1);
            }
        }
        else {
            int del = 0;
            int two_1 = 0;
            int two_2 = 0;
            // up
            int minimum_up = Math.min(Math.min(UP[first_value][first_goal],UP[second_value][second_goal]),UP[third_value][third_goal]);
            if (minimum_up == UP[first_value][first_goal]){
                del = UP[first_value][first_goal];
                two_1 = del + second_value;
                two_1 = two_1>10?10-two_1:two_1;
                two_2 = del + third_value;
                two_2 = two_2>10?10-two_2:two_2;
                up_count = counting(del) + two(two_1,two_2,lastindex);
            }
            else if (minimum_up == UP[second_value][second_goal]){
                del = UP[second_value][second_goal];
                two_1 = del + first_value;
                two_1 = two_1>10?10-two_1:two_1;
                two_2 = del + third_value;
                two_2 = two_2>10?10-two_2:two_2;
                up_count = counting(del) + one(two_1, lastindex-2) + one(two_2, lastindex);
            }
            else {
                del = UP[third_value][third_goal];
                two_1 = del + first_value;
                two_1 = two_1>10?10-two_1:two_1;
                two_2 = del + second_value;
                two_2 = two_2>10?10-two_2:two_2;
                up_count = counting(del) + two(two_1,two_2,lastindex-1);
            }
            // down
            int minimum_down = Math.min(Math.min(Down[first_value][first_goal],Down[second_value][second_goal]),Down[third_value][third_goal]);
            if (minimum_down == Down[first_value][first_goal]){
                del = Down[first_value][first_goal];
                two_1 = second_value - del;
                two_1 = two_1<0?two_1+10:two_1;
                two_2 = third_value - del;
                two_2 = two_2<0?two_2+10:two_2;
                down_count = counting(del) + two(two_1,two_2,lastindex);
            }
            else if (minimum_down == Down[second_value][second_goal]){
                del = Down[second_value][second_goal];
                two_1 = first_value - del;
                two_1 = two_1<0?two_1+10:two_1;
                two_2 = third_value - del;
                two_2 = two_2<0?two_2+10:two_2;
                down_count = counting(del) + one(two_1, lastindex-2) + one(two_2, lastindex);
            }
            else {
                del = Down[third_value][third_goal];
                two_1 = first_value - del;
                two_1 = two_1<0?two_1+10:two_1;
                two_2 = second_value - del;
                two_2 = two_2<0?two_2+10:two_2;
                down_count = counting(del) + two(two_1,two_2,lastindex-1);
            }
            if (up_count <= down_count) {
                return up_count;
            }
            else {
                return down_count;
            }
        }
    }
}

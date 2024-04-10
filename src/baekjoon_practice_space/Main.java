package baekjoon_practice_space;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static final int div = 1000;
    static int r;
    static int c;
    static int[][] table;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int min_x = 100;
    static int max_x = 0;
    static boolean[][] c_table = {}; // 방문 기록 table
    static boolean[][] not_f_table = {}; // 떨어지지 않는 클러스터
    static LinkedList<int[]> f_list = new LinkedList<>(); // 떨어지는 클러스터

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        // input
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        table = new int[r+1][c+1];

        // table input
        for (int i = 1; i <= r; i++) {
            String str = br.readLine();
            for (int j = 1; j <= c; j ++) {
                table[i][j] = str.charAt(j-1);
            }
        }

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a % 2 == 0) {
                Left(a);
            }
            else {
                Right(a);
            }
        }
    }
    public static boolean check (int a , int b) {
        c_table[a][b] = true;
        if (a == 1) {
            return true;
        }
        if (table[a-1][b] == 'x' && !c_table[a-1][b]) {
            if (check(a-1, b)) {
                not_f_table[a-1][b] = true;
                return true;
            }
            else {
                f_list.add(new int[2]);
                f_list.getLast()[0] = a;
                f_list.getLast()[1] = b;
                min_x = Math.min(min_x,b);
                max_x = Math.max(max_x,b);
                return false;
            }
        }
        else if (not_f_table[a-1][b]){
            return true;
        }
        if (table[a+1][b] == 'x' && !c_table[a+1][b]) {
            if (check(a+1, b)) {
                not_f_table[a+1][b] = true;
                return true;
            }
            else {
                f_list.add(new int[2]);
                f_list.getLast()[0] = a;
                f_list.getLast()[1] = b;
                min_x = Math.min(min_x,b);
                max_x = Math.max(max_x,b);
                return false;
            }
        }
        else if (not_f_table[a+1][b]){
            return true;
        }
        if (table[a][b-1] == 'x' && !c_table[a][b-1]) {
            if (check(a, b-1)) {
                not_f_table[a][b-1] = true;
                return true;
            }
            else {
                f_list.add(new int[2]);
                f_list.getLast()[0] = a;
                f_list.getLast()[1] = b;
                min_x = Math.min(min_x,b);
                max_x = Math.max(max_x,b);
                return false;
            }
        }
        else if (not_f_table[a][b-1]){
            return true;
        }
        if (table[a][b+1] == 'x' && !c_table[a][b+1]) {
            if (check(a, b+1)) {
                not_f_table[a][b] = true;
                return true;
            }
            else {
                f_list.add(new int[2]);
                f_list.getLast()[0] = a;
                f_list.getLast()[1] = b;
                min_x = Math.min(min_x,b);
                max_x = Math.max(max_x,b);
                return false;
            }
        }
        else if (not_f_table[a][b+1]){
            return true;
        }

        f_list.add(new int[2]);
        f_list.getLast()[0] = a;
        f_list.getLast()[1] = b;
        min_x = Math.min(min_x,b);
        max_x = Math.max(max_x,b);
        return false;
    }

    public static void fall () {

    }

    public static void reset() {

    }

    public static void Left (int h) {
        int i = 1;
        while(table[h][i] == '.') {
            if (i < c) {
                i++;
            }
            else {
                return;
            }
        }
        if (i == c || table[h+1][i+1] == '.' || table[h-1][i+1] == '.') {
            if (table[h-1][i] == 'x') {
                check(h-1,i);
            }
            if (table[h+1][i] == 'x') {
                check(h+1,i);
            }
            if (table[h][i-1] == 'x') {
                check(h,i-1);
            }
            if (table[h][i+1] == 'x') {
                check(h,i+1);
            }
        }
        table[h][i] = '.';
    }

    public static void Right (int h) {
        int i = c;
        while(table[h][i] == '.') {
            if (i > 1) {
                i--;
            }
            else {
                return;
            }
        }

        if (i == 1 || table[h+1][i-1] == '.' || table[h-1][i-1] == '.') {
            if (table[h-1][i] == 'x') {
                check(h-1,i);
            }
            if (table[h+1][i] == 'x') {
                check(h+1,i);
            }
            if (table[h][i-1] == 'x') {
                check(h,i-1);
            }
            if (table[h][i+1] == 'x') {
                check(h,i+1);
            }
        }
        table[h][i] = '.';
    }
}
package baekjoon_practice_since2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon_num2933 {
    static int r;
    static int c;
    static int[][] table;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean[][] c_table; // 방문 기록 table
    static boolean[][] not_f_table; // 떨어지지 않는 클러스터
    static Stack<int[]> f_dfs = new Stack<>();
    static Queue<int[]> f_list = new LinkedList<>(); // 떨어지는 클러스터

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        // input
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        table = new int[r+1][c+1];
        c_table = new boolean[r+1][c+1];
        not_f_table = new boolean[r+1][c+1];
        // table input
        for (int i = r; i >= 1; i--) {
            String str = br.readLine();
            for (int j = 1; j <= c; j ++) {
                table[i][j] = str.charAt(j-1);
            }
        }
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (i % 2 == 0) {
                Left(a);
            }
            else {
                Right(a);
            }
        }

        for (int i = r; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {
                System.out.print((char)table[i][j]);
            }
            System.out.println();
        }


    }
    public static boolean check (int a , int b) {
        f_dfs.add(new int[]{a,b});
        while(!f_dfs.isEmpty()) {
            int[] p = f_dfs.pop();
            c_table[p[0]][p[1]] = true; // 방문처리
            for (int i = 0; i < 4; i++) {
                if (p[0]+dy[i] < 1 || p[0]+dy[i] > r || p[1]+dx[i] < 1 || p[1]+dx[i] > c) continue; // 이동 불가능한 곳
                if (not_f_table[p[0]+dy[i]][p[1]+dx[i]] || (p[0]+dy[i] == 1 && table[p[0]+dy[i]][p[1]+dx[i]] == 'x')) { // 이미 떨어지지 않는 클러스터로 판명냈거나 난 곳이면
                    c_table[p[0]+dy[i]][p[1]+dx[i]] = true; // 방문 과정을 생략하고 방문처리
                    not_f_table = c_table;
                    c_table = new boolean[r+1][c+1];
                    f_dfs.clear();
                    return true;
                }
                if (table[p[0]+dy[i]][p[1]+dx[i]] == 'x' && !c_table[p[0]+dy[i]][p[1]+dx[i]]) {
                    f_dfs.add(new int[]{p[0]+dy[i], p[1]+dx[i]});
                }
            }
        }
        c_table = new boolean[r+1][c+1];
        return false;
    }

    public static void fall (int a, int b) {
        int min_x = 100, max_x = 0;
        int[] range_x_min_y = new int[101];
        f_dfs.add(new int[]{a,b});
        while(!f_dfs.isEmpty()) {
            int[] p = f_dfs.pop();
            f_list.add(new int[]{p[0],p[1]});
            min_x = Math.min(p[1],min_x);
            max_x = Math.max(p[1],max_x);
            range_x_min_y[p[1]] = (range_x_min_y[p[1]] != 0)? Math.min(p[0],range_x_min_y[p[1]]) : p[0];
            c_table[p[0]][p[1]] = true; // 방문처리
            for (int i = 0; i < 4; i++) {
                if (p[0]+dy[i] < 1 || p[0]+dy[i] > r || p[1]+dx[i] < 1 || p[1]+dx[i] > c) continue; // 이동 불가능한 곳
                if (table[p[0]+dy[i]][p[1]+dx[i]] == 'x' && !c_table[p[0]+dy[i]][p[1]+dx[i]]) {
                    f_dfs.add(new int[]{p[0]+dy[i], p[1]+dx[i]});
                }
            }
        }
        int move_min_y = 100;
        for (int i = min_x; i <= max_x; i++) {
            int move = 1;
            while (true){
                if (table[ range_x_min_y[i] - move ][i] == 'x' || range_x_min_y[i] - move == 0){
                    move--;
                    break;
                }
                move++;
            }
            move_min_y = Math.min(move ,move_min_y);
        }
        c_table = new boolean[r+1][c+1];;
        while(!f_list.isEmpty()) {
            int[] point = f_list.poll();
            if (!c_table[point[0]][point[1]]) table[ point[0] ][ point[1] ] = '.'; // 해당 위치로 내려온 적이 없으면
            table[ point[0] - move_min_y ][ point[1] ] = 'x';
            c_table[ point[0] - move_min_y ][ point[1] ] = true; // 방문처리
        }
    }

    public static void reset() {
        c_table = new boolean[r+1][c+1];
        not_f_table = new boolean[r+1][c+1];
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
        table[h][i] = '.';
        for (int k = 0; k < 4; k++) {
            if (h+dy[k] < 1 || h+dy[k] > r || i+dx[k] < 1 || i+dx[k] > c) continue;
            if (table[h+dy[k]][i+dx[k]] == 'x') {
                if (!check(h+dy[k],i+dx[k])) {
                    fall(h+dy[k], i+dx[k]);
                    break;
                }
            }
        }
        reset();
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
        table[h][i] = '.';
        for (int k = 0; k < 4; k++) {
            if (h+dy[k] < 1 || h+dy[k] > r || i+dx[k] < 1 || i+dx[k] > c) continue;
            if (table[h+dy[k]][i+dx[k]] == 'x') {
                if (!check(h+dy[k],i+dx[k])) {
                    fall(h+dy[k], i+dx[k]);
                    break;
                }
            }
        }
        reset();
    }
}

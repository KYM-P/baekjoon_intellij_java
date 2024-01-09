package baekjoon_practice_since2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main
{
    static int R;
    static int C;
    static int startx;
    static int starty;
    static char[][] table;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        table = new char[C][R];
        visit = new boolean[C][R];
        for (int i = 0; i < R; i++) {
            sb.append(br.readLine());
            for (int j = 0; j < C; j++) {
                table[j][i] = sb.charAt(j);
                if (table[j][i] == 'L'){
                    startx = j;
                    starty = i;
                }
            }
            sb.delete(0,C);
        }
        int count = 0;
        while (!DFS(startx, starty)) {
            patch();
            count++;
            //System.out.println(count);
        }
        /*
        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                System.out.print(table[x][y]);
            }
            System.out.println();
        }

         */
        System.out.println(count);
    }
    public static boolean DFS(int x, int y) {
        visit[x][y] = true;
        //System.out.println(x + " " + y + " " + startx + " " + starty + " " + (table[x][y] == 'L'));
        if (table[x][y] == 'L' && !(x == startx && y == starty)) {
            return true;
        }
        if (x+1 < C && table[x+1][y] != 'X' && visit[x+1][y] == false) {
            if (DFS(x+1,y)) {
                return true;
            }
        }
        if (x-1 >= 0 && table[x-1][y] != 'X' && visit[x-1][y] == false) {
            if (DFS(x-1,y)) {
                return true;
            }
        }
        if (y-1 >= 0 && table[x][y-1] != 'X' && visit[x][y-1] == false) {
            if (DFS(x,y-1)) {
                return true;
            }
        }
        if (y+1 < R && table[x][y+1] != 'X' && visit[x][y+1] == false) {
            if (DFS(x,y+1)) {
                return true;
            }
        }
        return false;
    }
    public static void patch() {
        Queue<Integer> q_x = new LinkedList<Integer>();
        Queue<Integer> q_y = new LinkedList<Integer>();
        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                visit[x][y] = false;
                if (table[x][y] == 'X') {
                    if (x+1 < C && table[x+1][y] == '.') {
                        q_x.offer(x);
                        q_y.offer(y);
                        table[x][y] = '#';
                    }
                    else if (x-1 >= 0 && table[x-1][y] == '.') {
                        q_x.offer(x);
                        q_y.offer(y);
                        table[x][y] = '#';
                    }
                    else if (y+1 < R && table[x][y+1] == '.') {
                        q_x.offer(x);
                        q_y.offer(y);
                        table[x][y] = '#';
                    }
                    else if (y-1 >= 0 && table[x][y-1] == '.') {
                        q_x.offer(x);
                        q_y.offer(y);
                        table[x][y] = '#';
                    }
                }
            }
        }
        while(!q_x.isEmpty()) {
            table[q_x.poll()][q_y.poll()] = '.';
        }
    }
}
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
    static char[][] table;
    static boolean[][] visit;
    static Queue<int[]> swan;
    static Queue<int[]> water;
    static int[] endpoint;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        table = new char[C][R];
        visit = new boolean[C][R];
        swan = new LinkedList<>();
        water = new LinkedList<>();
        endpoint = new int[2];
        for (int i = 0; i < R; i++) {
            sb.append(br.readLine());
            for (int j = 0; j < C; j++) {
                table[j][i] = sb.charAt(j);
                if (table[j][i] == 'L'){
                    if (swan.isEmpty()) {
                        swan.offer(new int[] {j,i});
                    }
                    else {
                        endpoint[0] = j;
                        endpoint[1] = i;
                    }
                }
                if (table[j][i] == '.') {
                    water.offer(new int[] {j, i});
                }
            }
            sb.delete(0,C);
        }
        int count = 0;
        while (!BFS()) {
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
    public static boolean BFS() {
        Queue<int []> search = new LinkedList<>();
        while(swan.isEmpty()) {
            int[] start = swan.poll();
            for (int i = 0; i < 4; i++) {
                int nx = start[0] + dx[i];
                int ny = start[1] + dy[i];
                if (nx < 0 || ny < 0 || nx > C-1 || ny > R-1 || visit[nx][ny]) {
                    continue;
                }
                visit[nx][ny] = true;
                if (table[nx][ny] == 'X') {
                    search.offer(new int[] {nx, ny});
                }
                else if (table[nx][ny] == '.') {
                    swan.offer(new int[] {nx,ny});
                }
            }
        }
        swan = search;
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
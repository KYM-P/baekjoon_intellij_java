package baekjoon_practice_since2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class beakjoon_num3197 {
    static int R;
    static int C;
    static char[][] table;
    static boolean[][] visit;
    static Queue<int[]> swan;
    static Queue<int[]> water;
    static int[] endpoint;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
                if (table[j][i] == 'L') {
                    if (swan.isEmpty()) {
                        swan.offer(new int[]{j, i});
                    } else {
                        endpoint[0] = j;
                        endpoint[1] = i;
                    }
                    water.offer(new int[]{j, i});
                }
                if (table[j][i] == '.') {
                    water.offer(new int[]{j, i});
                }
            }
            sb.delete(0, C);
        }
        int count = 0;
        while (!BFS()) {
            patch();
            count++;
            //System.out.println(count);
        }
        System.out.println(count);
    }

    public static boolean BFS() { // 현재 백조가 갈 수 있는 지역을 이동 and 다음에 녹을 칸을 미리 등록
        Queue<int[]> search = new LinkedList<>();
        while (!swan.isEmpty()) {
            int[] start = swan.poll();
            for (int i = 0; i < 4; i++) {
                int nx = start[0] + dx[i];
                int ny = start[1] + dy[i];
                if (nx < 0 || ny < 0 || nx > C - 1 || ny > R - 1 || visit[nx][ny]) {
                    continue;
                }
                visit[nx][ny] = true;
                if (table[nx][ny] == 'X') {
                    search.offer(new int[]{nx, ny});
                } else if (table[nx][ny] == '.') {
                    swan.offer(new int[]{nx, ny});
                } else if (nx == endpoint[0] && ny == endpoint[1]) {
                    return true;
                }
            }
        }
        swan = search;
        return false;
    }
    public static void patch () { // 하루 후 얼음과 물 (table) 상태 갱신
        int size = water.size();
        for (int i = 0; i < size; i++) {
            int[] q = water.poll();
            for (int j = 0; j < 4; j++) {
                int nx = q[0] + dx[j];
                int ny = q[1] + dy[j];

                if (nx < 0 || ny < 0 || nx > C - 1 || ny > R - 1) {
                    continue;
                }
                if (table[nx][ny] == 'X') {
                    table[nx][ny] = '.';
                    water.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
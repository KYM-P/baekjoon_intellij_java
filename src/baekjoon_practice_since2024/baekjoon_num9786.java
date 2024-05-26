package baekjoon_practice_since2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon_num9786 { // 우선순위 큐를 사용해 최단 경로를 탐색
    static int t = 0;
    static int h = 0,w = 0;
    static char[][] table;
    static int[][] pri;
    static int[] dx = new int[]{1, 0, -1 , 0};
    static int[] dy = new int[]{0, 1, 0 , -1};
    static String buffer = "";
    static boolean[][] visited;
    static int[][] dp; // 해당 지점에 도달하기 위한 3지점에서의 각자 문을 연 횟수(단 도착지점의 문은 1명만 열어도 됨)
    /* 3지점에서 각자 문을 열어 도착하는 값이 최소인 지점은 3지점이 중복되지 않은 문을 열어 만나게 되는 최솟값을 가지게 된다! */
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // input test case
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) { // test case
            // input table size
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            // input table
            table = new char[h+2][w+2];
            pri = new int[][]{{-1,-1},{-1,-1}};
            for(int j = 1; j <= h; j++){
                String s = br.readLine();
                for (int k = 1; k <= w; k++){
                    table[j][k] = s.charAt(k-1); // . empty, * wall, # door, $ prisoner
                    if (table[j][k] == '$'){ // prisoner memo
                        if(pri[0][0] == -1) { // pri[0]
                            pri[0][0] = j;
                            pri[0][1] = k;
                        }
                        else { // pri[1]
                            pri[1][0] = j;
                            pri[1][1] = k;
                        }
                    }
                }
            }
            // search
            dp = new int[h+2][w+2];
            bfs(0,0);
            bfs(pri[0][0],pri[0][1]);
            bfs(pri[1][0],pri[1][1]);
            int answer = -1;
            for(int j = 1; j <= h; j++){
                for (int k = 1; k <= w; k++){
                    if(!visited[j][k]){
                        continue;
                    }
                    if (table[j][k] == '#'){ // 3지점에서 만나는 지점이 문일경우 해당 지점은 1명만 열어도 되므로 -2
                        dp[j][k] -= 2;
                    }else if (table[j][k] == '*') {
                        continue;
                    }
                    answer = (answer == -1)? dp[j][k]:Math.min(dp[j][k],answer);
                }
            }
            buffer += answer;
            buffer += '\n';
        }
        System.out.println(buffer);
    }
    public static void bfs(int s_y, int s_x) {
        visited = new boolean[h+2][w+2];
        PriorityQueue<Main.pris> pq = new PriorityQueue<>(); // 우선순위큐 혹은 다른 방법으로 최단 거리를 탐색하여 dp에 저장 시켜야 한다.
        pq.add(new Main.pris(s_y,s_x,0));
        visited[s_y][s_x] = true;
        while(!pq.isEmpty()) {
            Main.pris p = pq.poll();
            dp[p.y][p.x] += p.count;
            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                int nc = p.count;
                if (ny > h + 1 || ny < 0 || nx > w + 1 || nx < 0)continue; // 범위 밖
                if (visited[ny][nx])continue; // 방문한 지역
                if (table[ny][nx] == '*')continue; // 벽
                if (table[ny][nx] == '#')nc++; // 문
                pq.add(new Main.pris(ny,nx,nc));
                visited[ny][nx] = true;
            }
        }
    }
    public static class pris implements Comparable<Main.pris>{
        int x, y, count;
        public pris (int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
        @Override
        public int compareTo(Main.pris p) {
            return this.count - p.count;
        }
    }
}

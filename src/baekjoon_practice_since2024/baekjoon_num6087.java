package baekjoon_practice_since2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_num6087 {
    static int table_wei;
    static int table_hei;
    static char[][] table;
    static int[][][] dp;
    static boolean[][][] visit;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static int[] start_p = new int[]{-1,-1};
    static int[] finish_p = new int[]{-1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // wei, hei input
        st = new StringTokenizer(br.readLine(), " ");
        table_wei = Integer.parseInt(st.nextToken());
        table_hei = Integer.parseInt(st.nextToken());
        //table input
        table = new char[table_wei][table_hei];
        for (int i = 0; i < table_hei; i++) {
            String s = br.readLine();
            for (int j = 0; j < table_wei; j++) {
                table[j][i] = s.charAt(j);
                if (table[j][i] == 'C'){ // C 지점
                    if(start_p[0] == -1){ // 시작지점이 없으면
                        start_p[0] = j; // 시작지점 설정
                        start_p[1] = i;
                    }else{
                        finish_p[0] = j; // 도착지점 설정
                        finish_p[1] = i;
                    }
                }
            }
        }
        // start
        dp = new int[table_wei][table_hei][5]; // dp[x][y][4] 는 모든 방향에서의 최소
        visit = new boolean[table_wei][table_hei][5]; // visit[x][y][방향] / 0 상, 1 하, 2 좌, 3 우, 4 1번이라도 방문한 곳
        point(start_p[0], start_p[1], -1, 4); // 첫 레이저 출발시에도 count 를 계산하므로 보정치 -1이 필요
        System.out.println(dp[finish_p[0]][finish_p[1]][4]);
    }
    // point / 좌표 이동
    // pre_way / 0 상, 1 하, 2 좌, 3 우, 4 시작
    public static boolean point(int x, int y, int count, int pre_way){
        if (visit[x][y][4] && dp[x][y][4] < count){
            return false;
        }
        else if (visit[x][y][pre_way] && dp[x][y][pre_way] == count){
            return false;
        }
        else{
            if (visit[x][y][4]){
                dp[x][y][4] = Math.min(dp[x][y][4], count);
            }else{
                dp[x][y][4] = count;
            }
            if(visit[x][y][pre_way]){
                dp[x][y][pre_way] = Math.min(dp[x][y][pre_way], count);
            }else {
                dp[x][y][pre_way] = count;
            }
            visit[x][y][4] = true;
            visit[x][y][pre_way] = true;
            if(finish_p[0] == x && finish_p[1] == y)return true; // 도착
            for (int i = 0; i < 4; i++) {
                if(x + dx[i] >= table_wei || x + dx[i] < 0 || y + dy[i] < 0 || y + dy[i] >= table_hei)continue; // 막다른 길
                if(table[x + dx[i]][y + dy[i]] == '*')continue; // 벽
                point(x + dx[i], y + dy[i], (pre_way == i)? count : count+1 , i); // 다음 point
            }
        }
        return true;
    }
}

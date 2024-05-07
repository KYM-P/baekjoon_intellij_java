package baekjoon_practice_since2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int t = 0;
    static int h = 0,w = 0;
    static char[][] table;
    static int[][] pri = new int[][]{{-1,-1},{-1,-1}};
    static int[] dx = new int[]{1, 0, -1 , 0};
    static int[] dy = new int[]{0, 1, 0 , -1};
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
            table = new char[h][w];
            for(int j = 0; j < h; j++){
                String s = br.readLine();
                for (int k = 0; k < w; k++){
                    table[j][i] = s.charAt(k); // . empty, * wall, # door, $ prisoner
                    if (table[j][i] == '$'){ // prisoner memo
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

        }
    }

}

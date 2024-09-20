package baekjoon_practice_since2024;


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int matrix_n;
    static int[][] dp;
    static int[] row;
    static int[] column;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        // input
        st = new StringTokenizer(br.readLine(), " ");
        matrix_n = Integer.parseInt(st.nextToken());
        dp = new int[matrix_n][matrix_n];
        for(int mn = 0; mn < matrix_n; mn++){
            st = new StringTokenizer(br.readLine(), " ");
            row[mn] = Integer.parseInt(st.nextToken());
            column[mn] =Integer.parseInt(st.nextToken());
        }
        // start
        for(int i = 0; i < matrix_n-1; i++) {
            dp[i][i+1] = row[i] * column[i] * column[i+1];
        }
        for(int i = 2; i < matrix_n-1; i ++) {
            for(int j = 0; j < matrix_n-i; j++) {
                for(int k = 1; k < i; k++) {
                    dp[j][j+i] = dp[j][j+k] + dp[j+k][j+i];
                }
            }
        }
    }
}
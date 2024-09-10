package baekjoon_practice_since2024;

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_num11066 {
    static int test_case = 0;
    static int[][][] dp; // dp[start_index][end_index][0] : start_index 부터 end_index 까지의 데이터의 합
    // dp[start_index][end_index][1] : start_index 부터 end_index 까지 합치면서 사용한 총 비용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        // test_case input
        st = new StringTokenizer(br.readLine(), " ");
        test_case = Integer.parseInt(st.nextToken());
        // test_case start
        while(test_case != 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int chapter_amount = Integer.parseInt(st.nextToken());
            // input
            dp = new int[chapter_amount][chapter_amount][2];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < chapter_amount; i++) {
                dp[i][i][0] = Integer.parseInt(st.nextToken());
            }
            // start
            for (int i = 1; i < chapter_amount; i++) {
                for (int j = 0; j < chapter_amount - i; j++) {
                    dp[j][j+i][0] = dp[j][j][0] + dp[j+1][j+i][0];
                    int value = Integer.MAX_VALUE;
                    for (int k = j; k < j+i; k++) { // dp[j][j+1] 를 만드는 모든 경우
                        value = Math.min(dp[j][k][1] + dp[k+1][j+i][1], value);
                    }
                    dp[j][j+i][1] += dp[j][j+i][0] + value;
                    //System.out.println("[" + j + ":" + (j+i) + "], dp0 : " + dp[j][j+i][0] + ", dp1 : " + dp[j][j+i][1]);
                }
            }
            bw.write(dp[0][chapter_amount-1][1] + "\n");
            test_case--;
        }
        bw.flush();
    }

}

package baekjoon_practice_since2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_num10830 {
    static final int div = 1000;
    static int n;
    static long b;
    static int[][] first;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());

        first = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 1; j <= n; j++) {
                first[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] result = process(b);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(result[i][j]%div + " ");
            }
            System.out.println();
        }

    }

    public static int[][] process (long c) {
        if (c == 1) {
            return first;
        }

        int[][] table = process(c/2);
        table = product(table, table);
        if (c % 2 == 0) {
            return table;
        }
        else {
            return product(table, first);
        }
    }

    public static int[][] product (int[][] x, int[][] y) {
        int[][] answer = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    answer[k][j] += x[i][j] * y[k][i];
                    answer[k][j] %=div;
                }
            }
        }

        return answer;
    }
}

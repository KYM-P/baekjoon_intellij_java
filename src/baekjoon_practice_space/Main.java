package baekjoon_practice_space;

import java.util.Scanner;

public class Main {
    static int N;
    static long[][][] DP;
    static int div = 1000000000;
    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);

        // list input
        N = sc.nextInt();

        // start
        DP = new long[N+1][10][10]; // [길이][시작값][끝값]
        DP[10][9][0] = 1;
        DP[10][0][9] = 1;
        for (int i = 11; i <= N; i++) {
            for (int j = 0; j < 10; j++) { // 시작값
                // k == 0
                DP[i][j][0] = DP[i-1][j][1]%div; // 뒤에 추가
                if (j == 0) {
                    DP[i][j][0] +=  DP[i-1][j+1][0]%div;
                }
                else if (j == 9){
                    DP[i][j][0] +=  DP[i-1][j-1][0]%div;
                }
                else {
                    DP[i][j][0] += (DP[i-1][j-1][0] + DP[i-1][j+1][0])%div;
                }
                DP[i][j][0] += (DP[i-2][j][0] * (i-3))%div;
                //System.out.println(i+ " " +j +" "+ 0 + " " +DP[i][j][0]);
                for (int k = 1; k < 9; k++) { // 끝값
                    if (j == 0) {
                        DP[i][j][k] = DP[i-1][j+1][k]%div; // 앞에 추가
                        DP[i][j][k] = (DP[i-1][j][k-1] + DP[i-1][j][k+1])%div; // 뒤에 추가
                    }
                    else if (j == 9){
                        DP[i][j][k] = DP[i-1][j-1][k]%div; // 앞에 추가
                        DP[i][j][k] = (DP[i-1][j][k-1] + DP[i-1][j][k+1])%div; // 뒤에 추가
                    }
                    else {
                        DP[i][j][k] = (DP[i-1][j-1][k] + DP[i-1][j+1][k])%div; // 앞에 추가
                        DP[i][j][k] = (DP[i-1][j][k-1] + DP[i-1][j][k+1])%div; // 뒤에 추가
                    }
                    DP[i][j][k] += (DP[i-2][j][k] * (i-3))%div;
                    //System.out.println(i+ " " +j +" "+ k + " " +DP[i][j][k]);
                }
                // k == 9
                DP[i][j][9] = DP[i-1][j][8]%div; // 뒤에 추가
                if (j == 0) {
                    DP[i][j][9] +=  DP[i-1][j+1][9]%div;
                }
                else if (j == 9){
                    DP[i][j][9] +=  DP[i-1][j-1][9]%div;
                }
                else {
                    DP[i][j][9] += (DP[i-1][j-1][9] + DP[i-1][j+1][9])%div;
                }
                DP[i][j][9] += (DP[i-2][j][9] * (i-3))%div;
                //System.out.println(i+ " " +j +" "+ 9 + " " +DP[i][j][9]);
            }
        }

        int result = 0;
        for (int i = 1; i < 10; i++) { // 시작값
            for (int j = 0; j < 10; j++) { // 끝값
                result += DP[N][i][j]%div;
                result %= div;
            }
        }
        System.out.println(result%div);
    }
}

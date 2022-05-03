package baekjoon_answer_record_DP;

import java.util.Scanner;

public class TableRoute {
    public static void main(String[] args) {

        int n = 0;
        int m = 0;
        int max = 0;

        Scanner sc = new Scanner(System.in);

        System.out.print("입력: ");

        n = sc.nextInt();
        m = sc.nextInt();


        int[][] DP_T1 = new int[m][n];
        int[][] Table = new int[m][n];

        // Table list input
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                Table[j][i] = sc.nextInt();
            }
        }


        // Table 첫 행 DP에 복제
        for(int i = 0; i < n; i++) {
            DP_T1[0][i] = Table[0][i];
        }

        // start
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = -1; k < 2; k++) {
                    if (j+k >= 0 && j+k < n) {
                        max = Math.max(DP_T1[i-1][j+k], max);
                    }
                }
                DP_T1[i][j] = max + Table[i][j];
                max = 0;
            }
        }

		/* another short coding
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int LeftUp, Left, LeftDown;

				if(i == 0) LeftUp = 0;
				else LeftUp = DP1[i-1][j-1];

				if(i == n-1) LeftDown = 0;
				else LeftDown = DP1[i+1][j-1];

				Left = DP1[i][j-1];
				DP_T1[i][j] = Table[i][j] + Math.max(LeftUp, Math.max(LeftDown,Left));
			}
		}
		*/

        // searching max
        max = DP_T1[m-1][0];
        for(int i = 1; i < n; i++) {
            max = Math.max(max, DP_T1[m-1][i]);
        }

        // answer output
        System.out.println(max);
    }
}

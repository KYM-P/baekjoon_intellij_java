package baekjoon_answer_record_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class num2579 { // Stair
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;

        n = Integer.parseInt(br.readLine());


        int[] DPT1 = new int[n+1];
        int[] Stair = new int[n+1];

        DPT1[0] = 0;
        Stair[0] = 0;
        // List Input
        for (int i = 1; i < n+1; i++) {
            Stair[i] = Integer.parseInt(br.readLine());
        }

        DPT1[1] = Stair[1];

        for (int i = 2; i < n+1; i ++) {
            if (i == 2) {
                DPT1[2] = Stair[1] + Stair[2];
            }
            else if (i == 3) {
                DPT1[3] = Math.max( Stair[1] , Stair[2]) + Stair[3];
            }
            else {
                DPT1[i] = Math.max( DPT1[i-3] + Stair[i-1], DPT1[i-2]) + Stair[i];
            }
        }
        System.out.println(DPT1[n]);
    }
}

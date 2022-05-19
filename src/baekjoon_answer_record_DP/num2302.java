package baekjoon_answer_record_DP;

import java.util.Scanner;

public class num2302 {
    static int N;
    static int M;
    static int[] VIP;
    static Integer[] DP;
    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);

        // list input
        N = sc.nextInt();
        M = sc.nextInt();

        DP = new Integer[N+1];

        if (M >= 1 && N >= M) {
            VIP = new int[M];
            for (int i = 0; i < M; i++) {
                VIP[i] = sc.nextInt();
                // VIP 와 VIP 다음석은 이전 자리와 교환이 불가능함을 표시
                DP[VIP[i]] = 0;
                if (VIP[i]+1 <= N) {
                    DP[VIP[i]+1] = 0;
                }
            }
        }

        // start
        DP[0] = 1;
        DP[1] = 1;
        for (int i = 2; i <= N; i++) {
            if (DP[i] == null) {
                DP[i] = DP[i-1]; // 이전 자리와 교환X 경우
                DP[i] += DP[i-2]; // 이전 자리와 교환 경우
            }
            else { // VIP 자리, VIP 다음 자리일 경우
                DP[i] = DP[i-1];
            }
        }
        System.out.println(DP[N]);
    }
}

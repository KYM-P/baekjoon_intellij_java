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
                // VIP �� VIP �������� ���� �ڸ��� ��ȯ�� �Ұ������� ǥ��
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
                DP[i] = DP[i-1]; // ���� �ڸ��� ��ȯX ���
                DP[i] += DP[i-2]; // ���� �ڸ��� ��ȯ ���
            }
            else { // VIP �ڸ�, VIP ���� �ڸ��� ���
                DP[i] = DP[i-1];
            }
        }
        System.out.println(DP[N]);
    }
}

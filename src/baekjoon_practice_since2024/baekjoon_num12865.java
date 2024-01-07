package baekjoon_practice_since2024;
import java.util.Scanner;
public class baekjoon_num12865 { // 백준 12865 냅색 알고리즘 (그리드 알고리즘)
    static int N;
    static int K;
    static int[] W;
    static int[] V;
    static int[] DP;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 물품 수, 한계 무게 입력
        N = sc.nextInt();
        K = sc.nextInt();
        // 물품별 무게, 가치 입력
        W = new int[N + 1]; // W[i] i 번째 무게
        V = new int[N + 1]; // V[i] i 번째 가치
        DP = new int[K + 1]; // 해당 무게에서의 최대 가치
        for (int i = 1; i <= N; i++) {
            W[i] = sc.nextInt();
            V[i] = sc.nextInt();
        }
        for (int i = 1; i <= N; i++) {
            for (int j = K; j >= W[i]; j--) {
                DP[j] = Math.max(DP[j - W[i]] + V[i], DP[j]);
            }
        }
        System.out.println(DP[K]);
    }
    /* 최적화 정답
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 물품 수, 한계 무게 입력
        N = sc.nextInt();
        K = sc.nextInt();
        // 물품별 무게, 가치 입력
        W = new int[N + 1]; // W[i] i 번째 무게
        V = new int[N + 1]; // V[i] i 번째 가치
        DP = new int[K + 1]; // 해당 무게에서의 최대 가치
        for (int i = 1; i <= N; i++) {
            W[i] = sc.nextInt();
            V[i] = sc.nextInt();
            for (int j = K; j >= W[i]; j--) {
                DP[j] = Math.max(DP[j - W[i]] + V[i], DP[j]);
            }
        }
        System.out.println(DP[K]);
    }
     */
}

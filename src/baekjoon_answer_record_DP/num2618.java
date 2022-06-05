package baekjoon_answer_record_DP;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class num2618 {

    static int N, W;
    static int[][] arrayA, minC;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());

        arrayA = new int[W+1][2];

        for(int i = 1; i <= W; i++) {
            st = new StringTokenizer(br.readLine());
            arrayA[i][0] = Integer.parseInt(st.nextToken());
            arrayA[i][1] = Integer.parseInt(st.nextToken());
        }

        minC = new int[W+1][W+1]; //�޸������̼� , 1�� ���� ���������� ó���� ��� ��ȣ : i, 2�� ���� ���������� ó���� ��� ��ȣ : j   [i][j] ��Ȳ���� ������ ������ �ִ� ��

        //�ʱⰪ : 0,0
        System.out.println(minCost(0,0)); //�ּҰ�

        pathCar(0,0); //��Ǻ� ó�� �� ��ȣ

        br.close();
        bw.close();

    }

    private static void pathCar(int a, int b) {
        if(a == W || b == W) {
            return;
        }

        int next = Math.max(a, b) + 1; // ���� ����� ��ġ
        int distA = Math.abs(arrayA[next][0] - (a==0?1:arrayA[a][0])) + Math.abs(arrayA[next][1] - (a==0?1:arrayA[a][1]))
                + minC[next][b]; //���� ����� 1�� ���� ó������ �� �ּҺ��
        int distB = Math.abs(arrayA[next][0] - (b==0?N:arrayA[b][0])) + Math.abs(arrayA[next][1] - (b==0?N:arrayA[b][1]))
                + minC[a][next]; //���� ����� 2�� ���� ó������ �� �ּҺ��

        if(distA < distB) {
            System.out.println(1);
            pathCar(next, b);
        } else {
            System.out.println(2);
            pathCar(a, next);
        }

    }

    // 1,2�� a, b ���� ��ġ
    private static int minCost(int a, int b) {

        if(a == W || b == W) {
            return 0;
        }

        if(minC[a][b] > 0) {
            return minC[a][b];
        }

        int next = Math.max(a, b) + 1; // ���� ����� ��ġ
        int distA = Math.abs(arrayA[next][0] - (a==0?1:arrayA[a][0])) + Math.abs(arrayA[next][1] - (a==0?1:arrayA[a][1]))
                + minCost(next, b); //���� ����� 1�� ���� ó������ �� �ּҺ��
        int distB = Math.abs(arrayA[next][0] - (b==0?N:arrayA[b][0])) + Math.abs(arrayA[next][1] - (b==0?N:arrayA[b][1]))
                + minCost(a, next); //���� ����� 2�� ���� ó������ �� �ּҺ��

        return minC[a][b] = Math.min(distA, distB); //�� �� �ּ� ���

    }

    /* ����
    static int N;
    static int M;
    static int[][] menu;
    static Integer[][] DP;
    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);

        // list input
        N = sc.nextInt();
        M = sc.nextInt();
        menu = new int[M+1][2];
        for (int i = 1; i <= M; i++) {
            menu[i][0] = sc.nextInt();
            menu[i][1] = sc.nextInt();
        }
        // start
        DP = new Integer[M+1][M+1]; // �ش� ��Ȳ���� ������ ������ �ִ� ��
        System.out.println(start(0,0));
        path(0,0);
    }
    public static int start(int point1, int point2) {
        int next = Math.max(point1, point2) + 1;
        if (next == M + 1) {
            DP[point1][point2] = 0;
            return 0;
        }
        if(DP[point1][point2] != null) {
            return DP[point1][point2];
        }
        DP[point1][point2] = Math.min(start(next,point2) + Math.abs((point1==0?1:menu[point1][0]) - menu[next][0]) + Math.abs((point1==0?1:menu[point1][1]) - menu[next][1]), start(point1,next) + Math.abs((point2==0?N:menu[point2][0]) - menu[next][0]) + Math.abs((point2==0?N:menu[point2][1]) - menu[next][1]));
        return DP[point1][point2];
    }
    public static void path(int point1, int point2) {
        int next = Math.max(point1, point2) + 1;
        if (next == M + 1) {
            return;
        }
        if (Math.abs((point1==0?1:menu[point1][0]) - menu[next][0]) + Math.abs((point1==0?1:menu[point1][1]) - menu[next][1]) + DP[next][point2] < Math.abs((point2==0?N:menu[point2][0]) - menu[next][0]) + Math.abs((point2==0?N:menu[point2][1]) - menu[next][1]) + DP[point1][next]) {
            System.out.println(1);
            path(next, point2);
        }
        else {
            System.out.println(2);
            path(point1, next);
        }
    }
     */
}

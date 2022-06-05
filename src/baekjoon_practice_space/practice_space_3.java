package baekjoon_practice_space;

import java.io.*;
import java.util.StringTokenizer;

public class practice_space_3 {
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

        minC = new int[W+1][W+1]; //�޸������̼� , 1�� ���� ���������� ó���� ��� ��ȣ : i, 2�� ���� ���������� ó���� ��� ��ȣ : j

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

}

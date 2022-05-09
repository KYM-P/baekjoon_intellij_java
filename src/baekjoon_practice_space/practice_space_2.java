package baekjoon_practice_space;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class practice_space_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // list input
        int N = sc.nextInt(); // 세로
        int M = sc.nextInt(); // 가로

        int[][] table = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                table[i][j] = sc.nextInt();
            }
        }

        // start
        Queue<int[]> q = new LinkedList<>();
        int result = 0;

        q.offer(new int[]{0,0});

        while (!q.isEmpty()){
            int x = q.peek()[0];
            int y = q.poll()[1];
            int height = table[y][x];
            System.out.print(height);
            if (x == M-1 && y == N-1) {
                System.out.print(" end\n");
                result++;
                continue;
            }
            if (x > 0 && table[y][x - 1] < height) { // left
                System.out.print(" left");
                q.offer(new int[]{x - 1,y});
            }
            if (y > 0 && table[y - 1][x] < height) { // up
                System.out.print(" up");
                q.offer(new int[]{x,y - 1});
            }
            if (x < M - 1 && table[y][x + 1] < height) { // right
                System.out.print(" right");
                q.offer(new int[]{x + 1,y});
            }
            if (y < N - 1 && table[y + 1][x] < height) { // down
                System.out.print(" down");
                q.offer(new int[]{x,y + 1});
            }
            System.out.print("\n");
        }
        System.out.println(result);
    }
}

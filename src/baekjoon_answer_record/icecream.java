package baekjoon_answer_record;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class icecream {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] table = new int[M][N];
        boolean[][] visited = new boolean[M][N];

         */
        int a = sc.nextInt(1);
        int b = sc.nextInt(1);
        System.out.println(a + " " + b);
        /*
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                table[i][j] = sc.nextInt(1);
            }
        }


        Queue<int[]> q = new LinkedList<>();
        int ice = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (table[i][j] == 0 && !visited[i][j]) {
                    q.offer(new int[]{i,j});
                }
                while (!q.isEmpty()) {
                    int x = q.peek()[0];
                    int y = q.poll()[1];
                    visited[x][y] = true;
                    if (x > 0 && table[x-1][y] != 1 && !visited[x-1][y]) { // left
                        q.offer(new int[]{x-1,y});
                    }
                    if (y > 0 && table[x][y-1] != 1 && !visited[x][y-1]) { // up
                        q.offer(new int[]{x,y-1});
                    }
                    if (x < M-1 && table[x+1][y] != 1 && !visited[x+1][y]) { // right
                        q.offer(new int[]{x+1,y});
                    }
                    if (y < N-1 && table[x][y+1] != 1 && !visited[x][y-1]) { // down
                        q.offer(new int[]{x,y+1});
                    }
                }
                ice++;
            }
        }
        System.out.println(ice);

         */
    }

}

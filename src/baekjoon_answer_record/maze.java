package baekjoon_answer_record;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class maze {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine(); // 버퍼 초기화

        int[][] table = new int[N+1][M+1];
        boolean[][] visited = new boolean[N+1][M+1];

        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                table[i+1][j+1] = str.charAt(j);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int depth = 1;
        q.offer(new int[]{1,1,depth});
        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            int next_depth = q.poll()[2] + 1;
            visited[y][x] = true;
            if (x == M && y == N){
                System.out.println(next_depth - 1);
                break;
            }
            if (x > 1 && table[y][x-1] != '0' && !visited[y][x-1]) { // left
                q.offer(new int[]{x-1,y,next_depth});
            }
            if (y > 1 && table[y-1][x] != '0' && !visited[y-1][x]) { // up
                q.offer(new int[]{x,y-1,next_depth});
            }
            if (x < M && table[y][x+1] != '0' && !visited[y][x+1]) { // right
                q.offer(new int[]{x+1,y,next_depth});
            }
            if (y < N && table[y+1][x] != '0' && !visited[y+1][x]) { // down
                q.offer(new int[]{x,y+1,next_depth});
            }
        }

    }

}

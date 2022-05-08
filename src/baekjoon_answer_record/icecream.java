package baekjoon_answer_record;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class icecream { // BFS

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] table = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        String str = sc.nextLine();
        int size = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (str.length() <= size){
                    str += sc.nextLine();
                }
                table[i][j] = str.charAt(size) - 48;
                size++;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int ice = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (table[i][j] == 0 && !visited[i][j]) {
                    q.offer(new int[]{i,j});
                    ice++;
                }
                while (!q.isEmpty()) { // BFS
                    int x = q.peek()[0];
                    int y = q.poll()[1];
                    visited[y][x] = true;
                    if (x > 0 && table[y][x-1] != 1 && !visited[y][x-1]) { // left
                        q.offer(new int[]{x-1,y});
                    }
                    if (y > 0 && table[y-1][x] != 1 && !visited[y-1][x]) { // up
                        q.offer(new int[]{x,y-1});
                    }
                    if (x < M-1 && table[y][x+1] != 1 && !visited[y][x+1]) { // right
                        q.offer(new int[]{x+1,y});
                    }
                    if (y < N-1 && table[y+1][x] != 1 && !visited[y+1][x]) { // down
                        q.offer(new int[]{x,y+1});
                    }
                }
            }
        }
        System.out.println("ice: " + ice);

    }

}

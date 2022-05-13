package baekjoon_practice_space;

import java.util.Scanner;
import java.util.Stack;

public class practice_space_1  {
    static int N;
    static int[][] map;
    static long sum = 0;
    static boolean[] visited;
    static long min = -1;

    static int length = 0;
    public static void main(String[] args) { // dp   TSP(TSProblem)
        Scanner sc = new Scanner(System.in);

        // list input
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // start
        System.out.println(root(0));
    }
    public static long root (int x) {
        if (length != N-1){
            for (int i = 1; i < N; i++) {
                //System.out.println("x: "+x+" i:" + i +" length: "+length);
                if (!visited[i] && map[x][i] != 0) {
                    visited[i] = true;
                    sum += map[x][i];
                    length += 1;
                    root(i);
                    visited[i] = false;
                    sum -= map[x][i];
                    length -= 1;
                }
            }
        }
        if (length != N-1 || map[x][0] == 0) {
            return min;
        }
        sum += map[x][0];
        if (min == -1) {
            min = sum;
        }
        else {
            min = Math.min(sum, min);
        }
        sum -= map[x][0];
        return min;
    }
}

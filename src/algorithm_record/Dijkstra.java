package algorithm_record;


import com.sun.jdi.VMMismatchException;

public class Dijkstra { // 다익스트라 알고리즘

    static int[][] table;
    static int[] minimum;
    static boolean[] visited;
    static int N = 4;

    public static void main(String[] args) {

        table = new int[N][N];
        visited = new boolean[N];
        minimum = new int[N];

        table[0][0] = 0;
        table[0][1] = 2;
        table[0][2] = 5;
        table[0][3] = 1;

        table[1][0] = 2;
        table[1][1] = 0;
        table[1][2] = 3;
        table[1][3] = 4;

        table[2][0] = 0;
        table[2][1] = 2;
        table[2][2] = 5;
        table[2][3] = 1;

        table[3][0] = 1;
        table[3][1] = 2;
        table[3][2] = 3;
        table[3][3] = 0;
        diik(0);
        System.out.println(minimum[3]); // index 3 까지의 최단 거리
    }

    public static int getSmallIndex() {
        int min = 1000000000;
        int index = 0;
        for (int i = 0; i < N; i++) {
            if (minimum[i] < min && !visited[i]) {
                min = minimum[i];
                index = i;
            }
        }
        return index;
    }

    public static void diik(int start) {
        for (int i = 0; i < N; i++) {
            minimum[i] = table[start][i];
        }
        visited[start] = true;
        for (int i = 0; i < N - 2; i++) {
            int current = getSmallIndex();
            visited[current] = true;
            for (int j = 0; j < N; j++) {
                if (!visited[j]) {
                    if (minimum[current] + table[current][j] < minimum[j]) {
                        minimum[j] = minimum[current] + table[current][j];
                    }
                }
            }
        }
    }
}

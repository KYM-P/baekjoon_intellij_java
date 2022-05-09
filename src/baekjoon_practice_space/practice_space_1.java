package baekjoon_practice_space;

import java.util.Scanner;
import java.util.Stack;

public class practice_space_1  {
    public static void main(String[] args)  {
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
        Stack<int[]> s = new Stack<>();
        int x = 0;
        int y = 0;
        int[] root = new int[]{0, 0, 0, 0};
        int count = 0;
        int result = 0;
        do {
            // 경로 탐색
            while ( !(x == M-1 && y == N-1) ) {
                int height = table[y][x];
                root[0] = 0;
                root[1] = 0;
                root[2] = 0;
                root[3] = 0;
                count = 0;
                if (x > 0 && table[y][x - 1] < height) { // left
                    root[0] = 1;
                    count++;
                }
                if (y > 0 && table[y - 1][x] < height) { // up
                    root[1] = 1;
                    count++;
                }
                if (x < M - 1 && table[y][x + 1] < height) { // right
                    root[2] = 1;
                    count++;
                }
                if (y < N - 1 && table[y + 1][x] < height) { // down
                    root[3] = 1;
                    count++;
                }
                if (count == 1) { // 길이 1가지라면
                    if (root[0] == 1) { // left
                        x = x - 1;
                    }
                    else if(root[1] == 1) { // up
                        y = y - 1;
                    }
                    else if(root[2] == 1) { // right
                        x = x + 1;
                    }
                    else { // down
                        y = y + 1;
                    }
                }
                else { // 길이 2가지 이상이거나 없으면
                    break;
                }
            }
            // 종착지
            if (x == M-1 && y == N-1) {
                result++;
            }

            if (count >= 2) { // 길이 2가지 이상이라면
                s.push(new int[]{x,y,root[0],root[1],root[2],root[3]});
            }
            while (!s.isEmpty()) {
                x = s.peek()[0];
                y = s.peek()[1];
                boolean change = false;
                for (int i = 2; i < 6; i++) {
                    if (s.peek()[i] == 1) {
                        s.peek()[i] = 0;
                        if (i == 2) { // left
                            x = x - 1;
                        }
                        else if(i == 3) { // up
                            y = y - 1;
                        }
                        else if(i == 4) { // right
                            x = x + 1;
                        }
                        else { // down
                            y = y + 1;
                        }
                        change = true;
                        break;
                    }
                }
                if (change) {
                    break;
                }
                else {
                    s.pop();
                }
            }
        }while(!s.isEmpty());
        System.out.println(result);
    }

}

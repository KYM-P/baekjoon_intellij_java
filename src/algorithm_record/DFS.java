package algorithm_record;

import java.util.ArrayList;
import java.util.Arrays;

public class DFS { // (Depth-First Search) Stack 형 방식 (기본 Stack 메모리를 사용해 재귀 함수로도 구현 가능)
    public static boolean[] visited = new boolean[9]; // 8개의 Node 상황 (1개는 index 0 으로 사용X)
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void main (String[] args) {
        graph.add(new ArrayList<>()); // index 0
        graph.add(new ArrayList<>(Arrays.asList(2,3,8))); // index 1
        graph.add(new ArrayList<>(Arrays.asList(1,7))); // index 2
        graph.add(new ArrayList<>(Arrays.asList(1,4,5))); // index 3
        graph.add(new ArrayList<>(Arrays.asList(3,5))); // index 4
        graph.add(new ArrayList<>(Arrays.asList(3,4))); // index 5
        graph.add(new ArrayList<>(Arrays.asList(7))); // index 6
        graph.add(new ArrayList<>(Arrays.asList(2,6,8))); // index 7
        graph.add(new ArrayList<>(Arrays.asList(1,7))); // index 8
        dfs(1);
    }

    public static void dfs (int x) {
        visited[x] = true; // 방문처리
        System.out.print(x + " ");

        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (!visited[y]) { // 재귀적 호출(방문)
                dfs(y);
            }
        }
    }

}

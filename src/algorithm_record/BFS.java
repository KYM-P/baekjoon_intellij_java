package algorithm_record;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS { // BFS (Breadth-First Search) Queue �� ���

    public static boolean[] visited = new boolean[9]; // 8���� Node ��Ȳ (1���� index 0 ���� ���X)
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
        bfs(1);
    }

    public static void bfs (int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true; // �湮ó��
        while (!q.isEmpty()){
            int x = q.poll();
            System.out.print(x + " ");
            for (int i = 0; i <graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if (!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }
    }

}

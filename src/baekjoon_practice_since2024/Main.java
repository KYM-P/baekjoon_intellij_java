package baekjoon_practice_since2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main
{
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> Up = new PriorityQueue<>();
        PriorityQueue<Integer> Down = new PriorityQueue<>(Collections.reverseOrder());

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num =Integer.parseInt(br.readLine());
            if (Up.size() == Down.size()) {
                Down.offer(num);
            }
            else {
                Up.offer(num);
            }
            if (!Up.isEmpty() && !Down.isEmpty()){
                if (Up.peek() < Down.peek()) {
                    int C = Down.poll();
                    Down.offer(Up.poll());
                    Up.offer(C);
                }
            }
            //System.out.print(Up);
            //System.out.println(Down);
            sb.append(Integer.toString(Down.peek())+"\n");
        }
        System.out.println(sb);
    }
}
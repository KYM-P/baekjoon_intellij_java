package baekjoon_practice_since2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class beakjoon_num1655 // 가운데를 말해요
{
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> Up = new PriorityQueue<>(); // 오름차순 queue
        PriorityQueue<Integer> Down = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 queue

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num =Integer.parseInt(br.readLine()); // 두 queue 중 내림차순에 먼저 넣고 오른차순에 먼저 넣음
            if (Up.size() == Down.size()) {
                Down.offer(num);
            }
            else {
                Up.offer(num);
            }
            if (!Up.isEmpty() && !Down.isEmpty()){ // 두 queue 모두 비어있지 않으면
                if (Up.peek() < Down.peek()) { // 오름차순 queue에 가장 낮은 값이 내림차순 queue의 가장 큰값보다 작다면
                    int C = Down.poll();
                    Down.offer(Up.poll());
                    Up.offer(C);
                    // 두 값을 교환 > 내림차순 queue에 첫번 째 값이 가운데 값이 되도록 유지
                }
            }
            //System.out.print(Up);
            //System.out.println(Down);
            sb.append(Integer.toString(Down.peek())+"\n");
        }
        System.out.println(sb);
    }
}
package baekjoon_practice_space;

import java.util.Stack;

public class practice_space_3 {
    public static void main (String[] args) {
        Stack<int[]> s = new Stack<>();
        s.push(new int[]{0,0});
        s.peek()[1] = 1;
        System.out.println(s.peek()[1]);
    }

}

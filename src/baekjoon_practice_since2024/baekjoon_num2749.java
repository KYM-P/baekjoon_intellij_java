package baekjoon_practice_since2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_num2749 {
    static long n = 0; // baekjoon 에서는 double로 long 처럼 정수를 표현할 수 없다. 그러므로 long 사용
    static int div = 1000000; // 나누는 값
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // input
        n = Long.parseLong(br.readLine());
        // output
        System.out.println(fibo(n));
    }
    public static int fibo(long fin) {
        fin = fin % 1500000; // 피사노 주기는 1500000 (식 15 x 10^(k-1)) ! 단 나누는값 M = 10^k 일 때 / 혹은 fibo(n)에서 result가 0, pre_result가 1이 되는 n값이 곧 피사노 주기가 된다.
        int result = 1; // 현재 node
        int pre_result = 1; // 이전 node

        if (fin == 0) { // 피보나치 0번째는 0
            return 0;
        }
        else if (fin <= 2) { // 피보나치 1,2번째는 1
            return result;
        }
        for (long i = 3; i <= fin; i++) { // 피보나치 3번째 부터 i 번째 피보나치 값을 찾는 과정
            int memo = result; // 스위칭을 위한 memo
            result = ((result % div) + (pre_result % div))%div; // 현재 node = 이전의 현재 node + 이전의 이전 node
            pre_result = memo % div; // 이전 node = 이전의 현재 node
        }
        return result;
    }
}

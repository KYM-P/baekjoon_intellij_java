package baekjoon_practice_since2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_num11401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        final int div = 1000000007;

        long deno = 1; // 분모
        long nume = 1; // 분자

        // 페르마의 소정리, 나머지 연산의 분배법칙 응용
        for (int i = n; i > k; i--) {
            nume *= i; // n! / r!
            nume %= div;
        }

        for (int i = 1; i <= n-k; i++) {
            deno *= i; // (n-r)!
            deno %= div;
        }
        // System.out.println(deno + " " + nume);

        // (nume / deno) % div == (nume * deno**(div-2))%div  : 단 div는 소수, deno는 div의 배수가 아닐 때
        long result = (nume * product_remainder(deno, div-2, div))%div;

        System.out.println(result);

    }

    public static long product_remainder(long a, long b, long c) { // a 밑, b 지수, c 나누는 값
        if (b == 1) {
            return a % c;
        }

        long div_power = product_remainder(a,b/2,c);

        if (b%2 == 0) {
            return (div_power * div_power) % c;
        }
        else {
            return (((div_power * div_power)%c) * a) % c;
        }
    }
}

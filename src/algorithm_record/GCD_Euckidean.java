package algorithm_record;

import java.util.Scanner;

public class GCD_Euckidean { // 유클리드 호제법 (최대 공약수 알고리즘)
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(gcd(a,b));
    }

    public static int gcd (int a, int b) { // 재귀 함수
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b); // A를 B로 나눈 나머지가 R이면 A와 B의 최대 공약수는 B와 R의 최대 공약수와 같다.
    }
}

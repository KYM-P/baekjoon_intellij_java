package algorithm_record;

import java.util.Scanner;

public class GCD_Euckidean { // ��Ŭ���� ȣ���� (�ִ� ����� �˰���)
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(gcd(a,b));
    }

    public static int gcd (int a, int b) { // ��� �Լ�
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b); // A�� B�� ���� �������� R�̸� A�� B�� �ִ� ������� B�� R�� �ִ� ������� ����.
    }
}

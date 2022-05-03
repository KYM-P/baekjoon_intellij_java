package baekjoon_answer_record_DP;

import java.util.ArrayList;
import java.util.Scanner;
import java.math.*;

public class Warehouse { // �� ���ڸ� �����ϸ� �ٷ� ���� ���ڴ� �������� ���ϴ� ��Ȳ������ �ִ밪 ã�� / 1 3 5 1 �̸� �ִ밡 1 + 5 = 6
    public static void main(String[] args) {

        int house = 0;
        int mini = 0;

        Scanner sc = new Scanner(System.in);

        System.out.print("�Է�: ");

        house = sc.nextInt();

        ArrayList<Integer> DP1 = new ArrayList<Integer>();
        ArrayList<Integer> InHouseNum = new ArrayList<Integer>();

        // list input
        for (int i =0; i < house; i++) {
            InHouseNum.add(sc.nextInt());
        }

        DP1.add(0);// index 0
        DP1.add(InHouseNum.get(0));

        // start
        for (int i = 1; i < house; i++) {
            mini = Math.max(DP1.get(i), DP1.get(i - 1) + InHouseNum.get(i));
            DP1.add(mini);
        }

        // answer output
        System.out.println(DP1.get(house));
    }
}

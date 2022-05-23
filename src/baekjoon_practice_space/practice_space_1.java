package baekjoon_practice_space;

import java.util.Scanner;

public class practice_space_1  {
    static String str1;
    static String str2;
    static Integer[][] DP;
    static int[][] skip;
    static int result = 0;
    static int count = 0;
    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);

        // list input
        str1 = sc.nextLine();
        str2 = sc.nextLine();

        // start
        DP = new Integer[26][4000];
        skip = new int[4000][2]; // [i][0] == �ǳʶ� ���� , [i][1] == �ǳʶٴ� Ƚ��
        for (int i = 0; i < str1.length(); i++) {
            if (DP[(int)str1.charAt(i) - 65][0] != null) {
                int j = 0;
                while (DP[(int)str1.charAt(i) - 65][j] != null) {
                    chase(i,DP[(int)str1.charAt(i) - 65][j],1);
                    j++;
                }
            }
            else {
                int size = 0;
                for (int j = 0; j < str2.length(); j++) {
                    if (skip[j][1] != 0) {
                        skip[j][1] -= count;
                        j += skip[j][0] - 1;
                        count = 1;
                    }
                    if (str1.charAt(i) == str2.charAt(j)) {
                        DP[(int)str1.charAt(i) - 65][size] = j;
                        size++;
                        chase(i,j,1);
                        skip[j][0] = count;
                        skip[j][1] = count;
                        count = 1;
                    }
                }
            }
            count++;
        }
        System.out.println(result);
    }
    public static void chase(int x1, int x2 ,int len) {
        x1 += 1;
        x2 += 1;
        if (x1 >= str1.length() || x2 >= str2.length()) {
            result = Math.max(result,len);
            count = len;
            return;
        }
        if (str1.charAt(x1) == str2.charAt(x2)){
            len += 1;
            chase(x1, x2, len);
            return;
        }
        result = Math.max(result,len);
        count = len;
        return;
    }
}

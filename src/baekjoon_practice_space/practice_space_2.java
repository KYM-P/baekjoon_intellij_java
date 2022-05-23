package baekjoon_practice_space;

import java.util.Scanner;

public class practice_space_2 {
    static String str1;
    static String str2;
    static int[][] skip;
    static int result = 0;
    static int count = 0;
    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);

        // list input
        str1 = sc.nextLine();
        str2 = sc.nextLine();

        // start
        skip = new int[4000][2]; // [i][0] == °Ç³Ê¶Û ±æÀÌ , [i][1] == °Ç³Ê¶Ù´Â È½¼ö
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                System.out.print(str1.charAt(i) + " to " + str2.charAt(j) + " " + j + ", ");
                if (skip[j][1] != 0) {
                    skip[j][1] -= 1;
                    j += skip[j][0];
                    System.out.print("skip to " + (j+1) + " ");
                }
                else if (str1.charAt(i) == str2.charAt(j)) {
                    chase(i,j,1);
                    //System.out.println(count);
                    skip[j][0] = count;
                    skip[j][1] = count;
                    j += skip[j][0];
                }
            }
            System.out.println("");
        }
        System.out.println(result);
    }
    public static void chase(int x1, int x2 ,int len) {
        x1 += 1;
        x2 += 1;
        if (x1 >= str1.length() || x2 >= str2.length()) {
            result = Math.max(result,len);
            count = len - 1;
            return;
        }
        if (str1.charAt(x1) == str2.charAt(x2)){
            len += 1;
            chase(x1, x2, len);
            return;
        }
        result = Math.max(result,len);
        count = len - 1;
        return;
    }
}

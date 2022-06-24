package baekjoon_practice_space;


import java.util.Scanner;

public class Main {
    static int N;
    static String table;
    static String goal;
    static int[] UP;
    static int[] Down;
    static int[] DP;
    public static void main(String[] args) { // dp
        Scanner sc = new Scanner(System.in);

        // list input
        N = sc.nextInt();
        sc.nextLine();
        table = sc.nextLine();
        goal = sc.nextLine();

        // start
        UP = new int[N+1];
        Down = new int[N+1];
        DP = new int[N+1];
        //System.out.println(table + " " + goal);
        for (int i = 1; i <= N; i++) {
            // case 1
            if (table.charAt(i-1) > goal.charAt(i-1)) {
                UP[i] = (10 - (table.charAt(i-1) - '0')) + (goal.charAt(i-1) - '0');
                Down[i] = Math.abs((table.charAt(i-1) - '0') - (goal.charAt(i-1) - '0'));
            }
            else if (table.charAt(i-1) < goal.charAt(i-1)) {
                UP[i] = Math.abs((table.charAt(i-1) - '0') - (goal.charAt(i-1) - '0'));
                Down[i] = (10 - (goal.charAt(i-1) - '0')) + (table.charAt(i-1) - '0');
            }
            else if (table.charAt(i-1) == goal.charAt(i-1)) {
                UP[i] = 0;
                Down[i] = 0;
            }
            int count = Math.min(UP[i], Down[i]);
            count = count/3 + ((count%3 > 0)?1:0);
            DP[i] = count + DP[i-1];
            // case 2 .
            if (i > 1) {
                // UP
                if (UP[i] <= UP[i-1]) {
                    count = UP[i]/3 + ((UP[i]%3 > 0)?1:0);
                    count += (UP[i-1] - UP[i])/3 + (((UP[i-1] - UP[i])%3 > 0)?1:0);
                    DP[i] = Math.min(count + DP[i-2],DP[i]);
                }
                else {
                    count = UP[i-1]/3 + ((UP[i-1]%3 > 0)?1:0);
                    count += (UP[i] - UP[i-1])/3 + (((UP[i] - UP[i-1])%3 > 0)?1:0);
                    DP[i] = Math.min(count + DP[i-2],DP[i]);
                }
                // Down
                if (Down[i] <= Down[i-1]) {
                    count = Down[i]/3 + ((Down[i]%3 > 0)?1:0);
                    count += (Down[i-1] - Down[i])/3 + (((Down[i-1] - Down[i])%3 > 0)?1:0);
                    DP[i] = Math.min(count + DP[i-2],DP[i]);
                }
                else {
                    count = Down[i-1]/3 + ((Down[i-1]%3 > 0)?1:0);
                    count += (Down[i] - Down[i-1])/3 + (((Down[i] - Down[i-1])%3 > 0)?1:0);
                    DP[i] = Math.min(count + DP[i-2],DP[i]);
                }

            }
            // case 3
            if (i > 2) {
                int[] sort = new int[3];
                if (Math.min(Math.min(UP[i], UP[i-1]),UP[i-2]) <= Math.min(Math.min(Down[i], Down[i-1]),Down[i-2])) {
                    // UP
                    sort[0] = Math.min(Math.min(UP[i], UP[i-1]),UP[i-2]);
                    sort[2] = Math.max(Math.max(UP[i], UP[i-1]),UP[i-2]);
                    for (int j = 0; j < 3; j++) {
                        if (UP[i-j] != sort[0] && UP[i-j] != sort[2]){
                            sort[1] = UP[i-j];
                            break;
                        }
                    }
                    count = sort[0]/3 + ((sort[0]%3 > 0)?1:0);
                    count += (sort[1] - sort[0])/3 + (((sort[1] - sort[0])%3 > 0)?1:0);
                    count += (sort[2] - sort[1])/3 + (((sort[2] - sort[1])%3 > 0)?1:0);
                    DP[i] = Math.min(count + DP[i-3],DP[i]);
                }
                else {
                    // Down
                    sort[0] = Math.min(Math.min(Down[i], Down[i-1]),Down[i-2]);
                    sort[2] = Math.max(Math.max(Down[i], Down[i-1]),Down[i-2]);
                    for (int j = 0; j < 3; j++) {
                        if (Down[i-j] != sort[0] && Down[i-j] != sort[2]){
                            sort[1] = Down[i-j];
                            break;
                        }
                    }
                    count = sort[0]/3 + ((sort[0]%3 > 0)?1:0);
                    count += (sort[1] - sort[0])/3 + (((sort[1] - sort[0])%3 > 0)?1:0);
                    count += (sort[2] - sort[1])/3 + (((sort[2] - sort[1])%3 > 0)?1:0);
                    DP[i] = Math.min(count + DP[i-3],DP[i]);
                }
                System.out.println(sort[0] + " " + sort[1] + " " + sort[2]);
            }
        }
        /*
        for (int i = 1; i <= N; i++) {
            System.out.println(UP[i] + " " + Down[i]);
        }

         */
        System.out.println(DP[N]);
    }
}

package baekjoon_practice_since2024;
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon_num6549 {

    static int rect_n;
    static int[] rect_table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String s;

        while (!(s = br.readLine()).equals("0")) {
            Stack<Integer> stack = new Stack<>();
            st = new StringTokenizer(s);
            rect_n = Integer.parseInt(st.nextToken());
            rect_table = new int[rect_n];
            for (int i = 0; i < rect_n; i++) rect_table[i] = Integer.parseInt(st.nextToken());
            long maxArea = 0;

            for (int i = 0; i < rect_n; i++) {
                /*
                 이전 높이가 현재 높이보다 크다면
                 현재 높이보다 큰 부분은 더이상 만들어지는 직사각형이 커질수 없으므로
                 직사각형 넓이를 미리 정의할 수 있음
                 */
                while ((!stack.isEmpty()) && rect_table[stack.peek()] >= rect_table[i]) {
                    long height = rect_table[stack.pop()];
                    long weight = (stack.isEmpty()) ? i : (i - stack.peek() - 1);
                    maxArea = Math.max(maxArea, height * weight);
                    /*
                     현재높이보다 낮은 모든 부분을 pop 하여 만들어지는 직사각형 계산
                     */
                }
                stack.push(i);
            }

            /*
            남아있는 스택값으로 계산 / 이때 남아있는 stack 에는 계단식으로 pop 이후 다음 pop 되는 값은 무조건 더 작아진다.
             */
            while (!stack.isEmpty()) {
                long height = rect_table[stack.pop()];
                long weight = (stack.isEmpty()) ? rect_n : (rect_n - stack.peek() - 1);
                maxArea = Math.max(maxArea, height * weight);
            }

            sb.append(maxArea).append('\n');
        }

        System.out.println(sb);
    }
}
/*
다른 풀이 : 분할정복으로 1~n 배열의 가운대 선정 > 오른쪽으로 진행했을 때의 최저 높이, 왼쪽으로 진행했을 때의 최저 높이를 비교하면서
더 높은쪽으로 진행해 1칸 진행할 때 마다 넓이 갱신 > 왼쪽과 오른쪽 모두 끝에 도달 할 때까지 진행 > 이후 가운대를 기준으로 왼쪽과
오른쪽 2개의 히스토그램으로 분할 (ex/ 넓이가 7이면 왼쪽 4개 오른쪽 3개) > 분할 이후 다시 가운대를 선정하여 반복 > 길이가 1이
될 때 까지 분할 > 최대값 도출

1차 실패 - 시간초과 - 입력과 동시에 모든 가능성을 검수하면서 계단식 배열로 입력할 경우 (ex 1 2 3 4 5 ...) O(n^2) 의 복잡도
import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int rect_n = 0;
    static long max_wide = 0;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine()," ");
            rect_n = Integer.parseInt(st.nextToken());
            if(rect_n == 0)break;
            HashMap<Integer,Integer> hm = new HashMap<>(); // HashMap<Key(세로),Value(가로)>
            for(int i = 0; i < rect_n; i++) {  // rect_n 번 반복
                int height_n = Integer.parseInt(st.nextToken()); // 현재 입력된 세로
                Integer[] rect_list = hm.keySet().toArray(new Integer[0]);
                //System.out.println(Arrays.stream(rect_list).toList() + " " + height_n + " , i : " + i);
                for( int j : rect_list ) { // hm 크기만큼 반복 / j = hm의 키값들(세로)
                    //System.out.println("j : " + j);
                    if ( j > height_n ) {
                        if ( !hm.containsKey(height_n) ){
                            hm.put(height_n, hm.get(j) + 1);
                            max_wide = Math.max(max_wide, hm.get(j) * j);
                            hm.remove(j);
                            //System.out.println("remove " + j);
                        }else {
                            max_wide = Math.max(max_wide, hm.get(j) * j);
                            hm.remove(j);
                            //System.out.println("remove " + j);
                        }
                    } else if ( j == height_n ) {
                        hm.replace(j, hm.get(j), hm.get(j) + 1);
                    } else { // j < height_n 인 경우
                        hm.replace(j, hm.get(j), hm.get(j) + 1);
                    }
                    //System.out.println("end " + Arrays.stream(rect_list).toList());
                }
                if( !hm.containsKey(height_n) ) {
                    hm.put(height_n, 1);
                }
            }
            for( int j : hm.keySet() ) {
                max_wide = Math.max(max_wide, hm.get(j) * j);
            }
            bw.write(max_wide + "\n");
            max_wide = 0;
        }
        bw.flush();
    }
}
// 2차실패 - 알고리즘 오류
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int rect_n = 0;
    static int[] rect_table;
    static long max_wide = 0;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        while(true){
            // 총 직사각형의 갯수 입력 / 0은 종료
            rect_n = Integer.parseInt(st.nextToken());
            if(rect_n == 0)break;
            // 모든 직사각형 정보 배열에 저장
            rect_table = new int[rect_n];
            for(int i = 0; i < rect_n; i++) {
                rect_table[i] = Integer.parseInt(st.nextToken());
            }
            // 배열을 통한 정사각형 크기 탐색
            Stack<Integer> low = new Stack<>();
            for(int i = 0; i < rect_n; i++) {
                if(low.isEmpty()){ // 현재 가장 작은 높이의 index 가 없을 떄
                    low.push(i);
                    continue;
                }
                if(rect_table[i-1] >= rect_table[i]){
                    while(!low.isEmpty()){
                        if(rect_table[low.peek()] < rect_table[i]){
                            break;
                        }
                    }
                    long wei = ( low.isEmpty() ) ? i : i - rect_table[low.peek()];
                    max_wide = Math.max(max_wide, wei * rect_table[i] );
                    low.push(i);
                }
                else {
                    max_wide = Math.max(max_wide,rect_table[i]); // 자기 자신
                }
            }
            long lowest_index = 0;
            while(low.isEmpty()){ // low 의 가장 첫 스택은 최저값
                lowest_index = low.pop();
            }
            max_wide = Math.max(max_wide, lowest_index * rect_n); // 자기 자신
        }
    }
}
 */
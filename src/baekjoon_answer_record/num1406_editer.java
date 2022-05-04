package baekjoon_answer_record;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class num1406_editer {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> in_cursor = new Stack<>();
        Stack<Character> out_cursor = new Stack<>();

        // stack input
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++){
            in_cursor.push(str.charAt(i));
        }

        // start
        int n = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        for (int i = 0; i < n; i++){
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine() , " ");
            }
            switch (st.nextToken().charAt(0)){
                case 'P':
                    in_cursor.push(st.nextToken().charAt(0));
                    break;
                case 'B':
                    if (!in_cursor.isEmpty()){
                        in_cursor.pop();
                    }
                    break;
                case 'L':
                    if(!in_cursor.isEmpty()){
                        out_cursor.push(in_cursor.pop());
                    }
                    break;
                case 'D':
                    if(!out_cursor.isEmpty()){
                        in_cursor.push(out_cursor.pop());
                    }
                    break;
            }
        }

        // answer output
        while (!out_cursor.isEmpty()){
            in_cursor.push(out_cursor.pop());
        }
        for (char answer : in_cursor){
            bw.write(answer);
        }
        bw.flush();
        bw.close();
    }
}

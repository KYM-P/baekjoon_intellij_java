package baekjoon_practice_space;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class practice_space_1  {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Character> list1 = new LinkedList<>();

        // list input
        //System.out.print("input str: ");
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++){
            list1.addLast(str.charAt(i));
        }

        // start
        //System.out.print("input int: ");
        int n = Integer.parseInt(br.readLine());
        int cursor = list1.size();

        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        for (int i = 0; i < n; i++){
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine() , " ");
            }
            //System.out.println(st.nextToken());
            switch (st.nextToken().charAt(0)){
                case 'P':
                    if (cursor == 0){
                        list1.addFirst(st.nextToken().charAt(0));
                    }
                    else if (cursor == list1.size()){
                        list1.addLast(st.nextToken().charAt(0));
                    }
                    else{
                        list1.add(cursor ,st.nextToken().charAt(0));
                    }
                    cursor += 1;
                    break;
                case 'B':
                    if (cursor == 0){
                        break;
                    }
                    else if (cursor == list1.size()){
                        list1.removeLast();
                        cursor -= 1;
                    }
                    else{
                        list1.remove(cursor - 1);
                        cursor -= 1;
                    }
                    break;
                case 'L':
                    if(cursor > 0){
                        cursor -= 1;
                    }
                    break;
                case 'D':
                    if(cursor < list1.size()){
                        cursor += 1;
                    }
                    break;
            }
        }

        for (char answer : list1){
            bw.write(answer);
        }
        bw.flush();
        bw.close();
    }

}

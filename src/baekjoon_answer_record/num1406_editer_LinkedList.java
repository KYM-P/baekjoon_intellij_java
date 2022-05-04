package baekjoon_answer_record;

import java.util.LinkedList;
import java.util.ListIterator;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;



public class num1406_editer_LinkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Character> List1 = new LinkedList<>();

        // list input
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++){
            List1.addLast(str.charAt(i));
        }

        // start
        ListIterator<Character> it = List1.listIterator(List1.size());

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        for (int i = 0; i < n; i++){
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine() , " ");
            }
            switch (st.nextToken().charAt(0)){
                case 'P':
                    it.add(st.nextToken().charAt(0));
                    break;
                case 'B':
                    if(it.hasPrevious()){
                        it.previous();
                        it.remove();
                    }
                    break;
                case 'L':
                    if(it.hasPrevious()){
                        it.previous();
                    }
                    break;
                case 'D':
                    if(it.hasNext()){
                        it.next();
                    }
                    break;
            }
        }
        for (char c : List1){
            bw.write(c);
        }
        bw.flush();
        bw.close();
    }
}

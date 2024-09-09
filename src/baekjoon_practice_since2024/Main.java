package baekjoon_practice_since2024;

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int test_case = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        // test_case input
        st = new StringTokenizer(br.readLine(), " ");
        test_case = Integer.parseInt(st.nextToken());

        // test_case start
        while(test_case != 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int chapter_amount = Integer.parseInt(st.nextToken());
            // input
            st = new StringTokenizer(br.readLine(), " ");
            LinkedList<Integer> chapter_list = new LinkedList<>();
            for(int i = 0; i < chapter_amount; i++) {
                chapter_list.add(Integer.parseInt(st.nextToken()));
            }
            // start
            PriorityQueue<SumValue> pq_up = new PriorityQueue<>();
            for (int i = 0; i < chapter_amount-1; i++) {
                pq_up.add(new SumValue( chapter_list.get(i), chapter_list.get(i+1), i,i+1));
            }
            int answer = 0;
            while(chapter_list.size() != 1) {
                SumValue s = pq_up.poll();
                if(s.BeforeIndex >= chapter_list.size()-1 || s.NextIndex >= chapter_list.size())continue;
                if(s.BeforeValue != chapter_list.get(s.BeforeIndex) || s.NextValue != chapter_list.get(s.NextIndex))continue;
                answer += s.getValue();
                chapter_list.add(s.BeforeIndex, s.getValue()); // BeforeIndex 자리에 새로 합친 chapter 등록
                chapter_list.remove(s.NextIndex);   // 합치기 전 두 chapter 삭제
                chapter_list.remove(s.NextIndex);
                if(s.BeforeIndex != 0) { // 새로 합친 chapter 를 NextIndex 로 등록
                    pq_up.add(new SumValue(chapter_list.get(s.BeforeIndex - 1), s.getValue(), s.BeforeIndex - 1, s.BeforeIndex));
                }
                if(s.BeforeIndex != chapter_list.size() - 1) { // 새로 합친 chapter 를 BeforeIndex 로 등록
                    pq_up.add(new SumValue(s.getValue(), chapter_list.get(s.BeforeIndex + 1), s.BeforeIndex, s.BeforeIndex + 1));
                }
                bw.write(chapter_list.toString() + "\n");
            }
            bw.write(answer + "\n");
            test_case--;
        }
        bw.flush();
    }

    static class SumValue implements Comparable<SumValue> {
        int BeforeValue;
        int NextValue;
        int BeforeIndex;
        int NextIndex;

        SumValue (int bv, int nv, int bi, int ni) {
            BeforeValue = bv;
            NextValue = nv;
            BeforeIndex = bi;
            NextIndex = ni;
        }
        public int getValue () {
            return BeforeValue + NextValue;
        }
        public int getBeforeValue () {
            return BeforeValue;
        }
        public int NextValue () {
            return NextValue;
        }
        public int BeforeIndex () {
            return BeforeIndex;
        }
        public int NextIndex () {
            return NextIndex;
        }
        public int compareTo(SumValue sv) { // 부모 안 compareTo 함수 Override
            return this.getValue() - sv.getValue(); // 양수가 나오면 우선순위 밀림 -> 오름차순
        }
    }
}
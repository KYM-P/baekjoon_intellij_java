package baekjoon_practice_space;


import java.util.*;
import java.io.*;

public class Main {
    //BFS탐색에 PriorityQueue에 사용될 클래스
    static class position implements Comparable<position>{
        int x,y, count;
        public position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;	//문을 연 횟수
        }
        //문을 연 횟수 기준 오름차순 정렬
        @Override
        public int compareTo(position o) {
            return this.count - o.count;
        }
    }
    static char[][] map;	//감옥 정보 저장 배열
    static ArrayList<position> prisoner;	//죄수 좌표 저장 리스트
    static int[] dx = {0, 0, -1, 1};	//상하좌우 x값 변경
    static int[] dy = {-1, 1, 0, 0};	//상하좌우 y값 변경
    static boolean[][] visited;		//감옥 공간 방문 배열
    //죄수1,죄수2,상근이 문을 연 횟수 저장 배열
    static int[][] prisonOne, prisonTwo, prisonThree;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력값 처리하는 BufferedReader
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //결과값 출력하는 BufferedWriter
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        //감옥 및 죄수 관련 정보 저장
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine()," ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            prisoner = new ArrayList<>();
            map = new char[h+2][w+2];
            prisoner.add(new position(0, 0, 0));
            for(int j=0;j<h;j++){
                String str = br.readLine();
                for(int s=0;s<w;s++){
                    map[j+1][s+1] = str.charAt(s);
                    if(map[j+1][s+1]=='$'){
                        prisoner.add(new position(s+1,j+1,0));
                    }
                }
            }

            prisonOne = bfs(prisoner.get(0), h, w);	//상근이 BFS탐색
            prisonTwo = bfs(prisoner.get(1), h, w); //죄수1 BFS탐색
            prisonThree = bfs(prisoner.get(2), h, w);	//죄수2 BFS탐색
            bw.write(minDoor(h, w) + "\n");	//문을 연 최소값 BufferedWriter 저장
        }
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //다익스트라 BFS탐색으로 이동가능한 공간에 최소 문을 연 횟수를 구하는 함수
    static int[][] bfs(position p, int h, int w){
        PriorityQueue<position> pq = new PriorityQueue<>();
        visited = new boolean[h+2][w+2];
        int[][] result = new int[h+2][w+2];	//문을 여는 횟수를 저장하는 배열
        visited[p.y][p.x] = true;
        pq.add(p);
        while(!pq.isEmpty()){
            position cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int count = cur.count;
            result[y][x] = count;
            //상하좌우 인접한 공간 확인
            for(int i=0;i<4;i++){
                int tempX = x + dx[i];
                int tempY = y + dy[i];
                if(tempX>=0 && tempY>=0 && tempX<w+2 && tempY<h+2 && !visited[tempY][tempX]){
                    if(map[tempY][tempX] != '*'){
                        if(map[tempY][tempX] == '#'){	//인접한 칸이 벽일 때
                            pq.add(new position(tempX,tempY,count+1));
                        } else		//인접한 칸이 빈 공간일 때
                            pq.add(new position(tempX,tempY,count));
                        visited[tempY][tempX] = true;
                    }
                }
            }
        }
        return result;
    }
    //상근, 죄수1, 죄수2에 문을 연 횟수를 통해서 최소값을 구하는 함수
    static int minDoor(int h, int w){
        int result = Integer.MAX_VALUE;
        for(int i=1;i<h+1;i++){
            for(int j=1;j<w+1;j++){
                if(map[i][j] == '*')	//막혀있는 공간일 때
                    continue;
                //문을 연 횟수 합 구하기
                int sum = prisonOne[i][j] + prisonTwo[i][j] + prisonThree[i][j];
                if(map[i][j] == '#')	//벽일 때
                    sum-=2;		//2번 중복되어 문을 연 값 빼기
                /*
                최소값을 구할 때 방문확인을 하는 이유는
                해당 칸이 '*'으로 둘러싸여 있으면 방문하지 못하지만 문을 연 횟수는
                0이기 때문에 최소값이 될 수 있는 것을 방지하기 위함입니다.
                */
                if(result > sum && visited[i][j]){
                    result = sum;
                }
            }
        }
        return result;	//최소값 반환
    }
}
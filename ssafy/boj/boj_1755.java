package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * boj_1755 숫자놀이
 *
 * 1. n~m사이를 반복문으로 돌면서 영어 문자열로 변환한다.
 * 2. 우선순위 큐에 넣고, comparable 오버라이딩한다. -> String 비교
 */
public class boj_1755 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static String[] numStr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        sb = new StringBuilder();

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        //우선순위 큐를 사용해서 자동정렬
        PriorityQueue<Comp> queue = new PriorityQueue<>();

        //start~end까지 반복
        for(int idx=start; idx<=end; idx++){
            String str = "";
            //숫자 -> 영어 변환
            if(idx<10){
                str = numStr[idx];
            }else {
                str += numStr[idx/10];
                str += " "; //10이상일 때 가운데에 공백을 포함
                str += numStr[idx%10];
            }
            queue.offer(new Comp(str, idx));//우선순위 큐에 담기
            System.out.println("dkdk"+queue.peek());
        }
        int cnt = 0; //한줄에 10개씩 출력하기 위한 변수
        while(!queue.isEmpty()){
            Comp c = queue.poll(); // 큐에서 뺀다.
            cnt++;
            //넣을 때는 영어, 숫자, 출력할 때는 숫자만 출력
            sb.append(c.idx).append(" ");
            if(cnt%10 == 0){
                sb.append("\n");
            }
        }
        System.out.println(sb);

    }
    //원하는 방식으로 정렬
    static class Comp implements Comparable<Comp>{
        String str;
        int idx;
        public Comp(String str, int idx){
            super();
            this.str = str;
            this.idx = idx;
        }
        public String getString() {
            return this.str;
        }
        public int getIdx() {
            return this.idx;
        }
        @Override
        public int compareTo(Comp o) {
            //string만 가지고 사전순으로 정렬하기
            return getString().compareTo(o.getString());
        }
    }
}

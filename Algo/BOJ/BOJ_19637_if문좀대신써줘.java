package study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj_19637_if문좀대신써줘
 * 1초 1024mb
 *
 * 문제
 * 1. 10000 >= WEAK
 * 2. 10000 < NORMAL <= 100000
 * 3. 100000 < STRONG <= 1000000
 * 4. 칭호가 여러개인 경우 가장 먼저 입력된 칭호 하나만 출력
 *
 * 문풀
 * 이분탐색안하면 입력값이 10만이기 때문에 시간초과가 난다.
 */

public class BOJ_19637_if문좀대신써줘 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static int name, count; //칭호개수, 캐릭터개수
    static Pro[] game;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine().trim());
        sb = new StringBuilder();

        name = Integer.parseInt(st.nextToken());
        count = Integer.parseInt(st.nextToken());
        game = new Pro[name];

        //칭호개수
        for(int idx=0; idx<name; idx++){
            st = new StringTokenizer(br.readLine().trim());

            String call = st.nextToken();
            int rate = Integer.parseInt(st.nextToken());

            game[idx] = new Pro(call, rate);
        }

        //캐릭터 개수
        for(int idx=0; idx<count; idx++){
            int input = Integer.parseInt(br.readLine().trim());

            //이진탐색해서 판별해야함
            sb.append(binary(input)).append("\n");
        }
        System.out.println(sb.toString());
    }

    //이진탐색 - 이미 오름차순으로 주어짐
    static String binary(int input){
        int start = 0;
        int mid = 0;
        int end = name -1;

        while(start <= end){
            mid = (start + end) / 2;
            if(input > game[mid].rate) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return game[end+1].call;
    }

    //캐릭터 타입
    static class Pro {
        String call;
        int rate;
        public Pro(String call, int rate) {
            this.call = call;
            this.rate = rate;
        }
    }
}

package swea;
/**
 * 1. 반복문을 돌면서 sb에 알파벳을 이어붙인다.
 * 2. 출력시 10씩 나눠서 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1946 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;
    static String str;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb= new StringBuilder();
        int testCase = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=testCase; tc++){
            int smallCase = Integer.parseInt(br.readLine().trim());
            str="";
            for(int sc=0; sc<smallCase; sc++){
                st = new StringTokenizer(br.readLine().trim());
                String alpha = st.nextToken();
                int cnt = Integer.parseInt(st.nextToken());

                for(int idx=0; idx<cnt; idx++){
                    str += alpha;
                }
            }
            sb.append("#").append(tc).append("\n");

            //10개마다 엔터로 출력하기
            for(int listIdx=0; listIdx<str.length(); listIdx++){
                sb.append(str.charAt(listIdx));
                if(listIdx %10 == 9) {
                    sb.append("\n");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

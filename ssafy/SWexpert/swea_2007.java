package swea;
/**
 * 1. 첫 글자와 첫글자 이후 ~ 반복적인 마디의 길이만큼 문자를 잘라 비교한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2007 {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=testCase; tc++){
            String str = br.readLine().trim();
            sb = new StringBuilder();

            int count = 1;
            //초기값 설정
            sb.append(str.charAt(0));
            //sb에 담긴 글자랑 str에서 sb에서 담긴 글자 이후~sb 길이만큼을 1씩 증가시키면서 비교
            while(!sb.toString().equals(str.substring(sb.length(), sb.length()*2))){
                sb.append(str.charAt(count));
                count++;
            }
            System.out.println("#"+tc+" "+sb.length());
        }
    }
}

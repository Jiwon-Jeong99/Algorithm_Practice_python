package study.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * boj_1316_그룹단어체커
 * 2초 128mb
 *
 * 문제
 * 1. 처음에는 주어진 단어들을 다 붙여서 그룹단어를 찾는건줄 알고 문제가 3일 동안 이해 안됨 레전드
 *
 * 문풀
 * 1. 각 string의 char를 돌면서 중복되는 게 또 나오나 확인하면 된다.
 */

public class BOJ_1316_그룹단어체커 {
    static BufferedReader br;

    static int answer; //총 개수
    static boolean flag;
    static boolean[] alpha;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        answer = 0;

        int testCase = Integer.parseInt(br.readLine().trim());
        for(int tc=0; tc<testCase; tc++){
            char[] chr = br.readLine().trim().toCharArray();

            flag = true;
            alpha = new boolean[26]; //알파벳 26개

            for(int idx=0; idx<chr.length; idx++){
                int num = chr[idx] - 'a'; //char -> 숫자로 변환

                if(!alpha[num]){ //이미 도달한 적이 없는 알파벳이라면
                    alpha[num] = true;
                }else if(idx > 0 && chr[idx] != chr[idx-1]){ //도달한 적이 있는데 전 알파벳과 다르다면
                    flag = false;
                    break;
                }
            }
            //그룹단어만 있다면 +1
            if(flag) answer++;
        }
        System.out.println(answer);
        br.close();
    }
}

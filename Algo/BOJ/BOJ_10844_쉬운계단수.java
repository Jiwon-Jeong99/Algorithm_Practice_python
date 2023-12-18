package study.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * boj_10844_쉬운계단수
 * 1초 256mb
 *
 * 문제
 * 1. 인접한 모든 자리의 차이가 1인 수 => 계단 수
 * 2. 0으로 시작하는 수는 계단수가 아니다.
 *
 * 문풀
 * 참고 https://st-lab.tistory.com/134
 * 1. 끝자리가 9이면 옆자리는 8일수밖에 없다.
 * 2. 끝자리가 0이면 옆자리는 1일수밖에 없다.
 * 3. 앞자리가 0일수는 없다.
 * 4. top-down 방식으로 dp로 품
 * 5. 이차원배열로 자릿수(numIdx), 자리의값(value)을 표현
 */

public class BOJ_10844_쉬운계단수 {
    static BufferedReader br;
    static final int DIVIDE_NUM = 1000000000;
    static Long[][] dp;
    static int length;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        length = Integer.parseInt(br.readLine().trim());
        dp = new Long[length+1][10]; //0~9

        //첫 자릿수는 1로 - 첫째 자릿수는 끝이기 때문에 경우의 수가 1밖에 없기 때문
        for(int idx=0; idx<10; idx++){
            dp[1][idx] = (long)1;
        }

        long result = 0;

        //모든 경우 구하기
        for(int idx=1; idx<=9; idx++){
            result += recursion(length, idx);
        }
        System.out.println(result % DIVIDE_NUM);
    }

    //재귀
    static long recursion(int numIdx, int value){
        //첫째 자릿수만 하면 탐색 필요x
        if(numIdx == 1){
            return dp[numIdx][value];
        }

        //해당 자리 value를 아직 탐색하지 않은 경우
        if(dp[numIdx][value] == null) {
            //value가 0일 경우 1만 올 수 있음
            if(value == 0){
                dp[numIdx][value] = recursion(numIdx-1,1);
            }

            //value가 9일 경우 8만 올 수 있음
            else if(value == 9) {
                dp[numIdx][value] = recursion(numIdx-1,8);
            }

            //그외
            else{
                dp[numIdx][value] = recursion(numIdx-1, value-1)+recursion(numIdx-1, value+1);
            }
        }
        return dp[numIdx][value] % DIVIDE_NUM;
    }
}

package study.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * boj_18222_투에모스문자열
 * 1초 256mb
 *
 * 문제
 * 1. 0과 1로 이루어진 무한한 문자열 X
 * 2. 맨처음은 0으로 시작
 * 3. 0->1, 1->0으로 뒤바꾼 문자열 X 만듦
 * 4. X뒤에 X붙인 문자열로 X다시 정의
 * 5. 3,4 무한반복
 *
 * 문풀
 * semin 참고
 * 1. 10^8이니까 long으로 타입 설정(20만 초과)
 * N[0] = 0
 * N[2n] = N[n] //짝수
 * N[2n+1] = 1 - N[n] //홀수
 */

public class BOJ_18222_투에모스문자열 {
    static BufferedReader br;
    static long num;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        num = Long.parseLong(br.readLine().trim());
        System.out.println(twomos(num-1)); //인덱스 기준
    }

    //투에모스 메서드
    static int twomos(long depth) {
        if(depth == 0) return 0; //첫 인덱스
        else if(depth % 2 == 0){
            //짝수일때
            return twomos(depth >>= 1); //depth/2
        }
        else{//홀수일때
            return (1 - twomos(depth >>= 1));
        }
    }
}

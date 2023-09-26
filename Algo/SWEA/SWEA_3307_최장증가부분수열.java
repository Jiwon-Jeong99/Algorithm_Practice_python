package swea;

/**
 * swea_3307 최장증가부분수열
 *
 * 문제
 * 1. 수가 증가하는 부분, 즉 최장증가부분수열을 구하라
 *
 * 문풀
 * 1. 테스트케이스를 입력받는다.
 * 2. 수열의 길이 입력받기.
 * 3. 수열 입력받고 배열에 넣기.
 * 4. dp로 LIS를 저장할 1차원 dp테이블 생성
 * 5. 초기 dp테이블은 다 1로 채운다.
 * 6. 해당 인덱스 전 인덱스의 값들을 순회하면서 현재의 인덱스 값이 더 크다면 dp[그전 인덱스]+1
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3307_최장증가부분수열 {
    static BufferedReader br;
    static StringTokenizer st;

    static int length; //수열의 길이
    static int[] nums; //원소의 배열
    static int[] dp; //dp테이블
    static int compare; //비교하는 수
    static int max; //최장수열 길이

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        //1. 테스트케이스를 입력받는다.
        int testCase = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=testCase; tc++) {
            max = Integer.MIN_VALUE;
            //2. 수열의 길이 입력받기.
            length = Integer.parseInt(br.readLine().trim());

            nums = new int[length];

            //3. 수열 입력받고 배열에 넣기.
            st = new StringTokenizer(br.readLine().trim());
            for(int idx=0; idx<length; idx++){
                nums[idx] = Integer.parseInt(st.nextToken());
            }

            //4. dp로 LIS를 저장할 1차원 dp테이블 생성
            dp = new int[length];

            dp[0] = 1;

            for(int index=1; index<length; index++){
                //5. 초기 dp테이블은 다 1로 채운다.
                dp[index] = 1;

                //6. 해당 인덱스 전 인덱스의 값들을 순회하면서 현재의 인덱스 값이 더 크다면 dp[그전 인덱스]+1
                for(int sIdx=0; sIdx<index; sIdx++) {
                    if (nums[index] > nums[sIdx]) {
                        dp[index] = Math.max(dp[index], dp[sIdx]+1);
                    }
                }
            }

            for(int idx=0; idx<length; idx++){
                max = Math.max(max, dp[idx]);
            }

            System.out.println("#"+tc+" "+ max);
        }
    }
}

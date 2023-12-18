package study.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj_2503_숫자야구
 * 1초 128mb
 *
 * 문제
 * 1. 1~9 서로다른 숫자 3개로 구성된 세자리 수
 * 2. 동일한 자리, 동일한 숫자 => 스트라이크
 *    다른 자리, 동일한 숫자 => 볼
 * => 영수가 생각하고 있을 답의 총 개수
 *
 * 문풀
 * 1. 스트라이크, 볼 순서
 * 2. 0이 들어갔을 경우, 같은 숫자가 있을 경우 예외처리
 * 3. 123 ~ 987까지 돌면서 입력받은 수에 대해 가능성이 있으면 true로
 */

public class BOJ_2503_숫자야구 {
    static BufferedReader br;
    static StringTokenizer st;
    static int answer = 0;

    static boolean[] nums = new boolean[988]; //~987까지 가능하니까

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        //nums 배열에서 숫자야구에서 가능한 수만 true로 바꾸기
        for(int idx=123; idx<988; idx++){
            String numStr = Integer.toString(idx); //number -> string으로 바꿔서 각 자리 접근

            //0이 존재하면 안됨
            if(numStr.charAt(0) == '0' || numStr.charAt(1) == '0' || numStr.charAt(2) == '0') continue;

            //모든 자릿수가 달라야 됨
            if(numStr.charAt(0) == numStr.charAt(1) || numStr.charAt(0) == numStr.charAt(2) || numStr.charAt(1) == numStr.charAt(2)) continue;

            //아니면 다 true
            else nums[idx] = true;
        }

        int testCase = Integer.parseInt(br.readLine().trim());
        for(int tc=0; tc<testCase; tc++){
            st = new StringTokenizer(br.readLine().trim());
            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            //만약 nums가 true여서 가능한 수라면
            for(int idx=123; idx<988; idx++){
                if(nums[idx]){
                    int strikeCnt = 0;
                    int ballCnt = 0;

                    //true인 수와 입력받은 수를 비교
                    //입력받은 수 각 자리수 비교
                    for(int input=0; input<3; input++){
                        char input_idx = Integer.toString(num).charAt(input);

                        //true인 수들 중 각 자리수 비교
                        for(int trues=0; trues<3; trues++){
                            char trues_idx = Integer.toString(idx).charAt(trues);

                            //비교해서 스트라이크와 볼 카운트
                            if(input_idx == trues_idx && input == trues) strikeCnt++;
                            else if(input_idx == trues_idx && input != trues) ballCnt++;
                        }
                    }

                    //주어진 스트라이크, 볼과 비교했을 때 가능성이 있으면 true
                    if(strikeCnt == strike && ballCnt == ball) nums[idx] = true;
                    else nums[idx] = false;
                }
            }
        }

        for(int idx=123; idx<988; idx++){
            if(nums[idx]) answer++;
        }

        System.out.println(answer);
    }
}

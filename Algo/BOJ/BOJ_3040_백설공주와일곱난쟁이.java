package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * boj_3040 백설공주와일곱난쟁이
 * 1초 128mb
 *
 * 문제
 * 1. 의자 7개, 접시 7개, 나이프 7개 준비
 * 2. 9명의 난쟁이가 돌아왔다.
 * 3. 일곱난쟁이의 모자 숫자합은 100이 된다.
 * 4. 일곱난쟁이를 찾아라.
 *
 * 문풀
 * 1. 조합으로 7개를 뽑고 그 합이 100이 되면 순서대로 출력하게 만든다.
 *
 */
public class BOJ_3040_백설공주와일곱난쟁이 {
    static BufferedReader br;

    static int[] nums;
    static int[] selectList;

    static final int REAL_TOTAL = 7;
    static final int JUST_TOTAL = 9;
    public static void main(String[] args) throws IOException, NumberFormatException {
        br = new BufferedReader(new InputStreamReader(System.in));

        nums = new int[JUST_TOTAL];
        selectList = new int[REAL_TOTAL];

        for(int idx=0; idx<JUST_TOTAL; idx++){
            int num = Integer.parseInt(br.readLine().trim());
            nums[idx] = num;
        }

        combination(0,0);
    }

    //조합
    public static void combination(int start, int depth) {
        if(depth == REAL_TOTAL) {
            int sum=0;
            for(int idx=0; idx<REAL_TOTAL; idx++){
                sum += selectList[idx];
            }
            if(sum == 100){
                for(int index=0; index<REAL_TOTAL; index++){
                   System.out.println(selectList[index]);
                }
            }
            return;
        }

        if(start == JUST_TOTAL) {
            return;
        }

        selectList[depth] = nums[start];
        combination(start+1, depth+1);

        selectList[depth]=0;
        combination(start+1, depth);
    }
}

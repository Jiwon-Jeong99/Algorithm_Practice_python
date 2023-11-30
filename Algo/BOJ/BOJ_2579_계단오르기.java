package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * dp
 * 1. 계단은 한번에 1 or 2 계단씩 오를 수 있다.
 * 2. 연속된 3개의 계단을 모두 밟아서는 안된다. (시작점은 계단에 포함x)
 * 3. 마지막 도착 계단은 반드시 밟아야 한다.
 */

public class BOJ_2579_계단오르기 {
    static BufferedReader br;
    static int[] nums;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine().trim());

        //계단 시작점 포함 배열 생성
        nums = new int[len+1];

        //계단 배열에 넣기
        for(int tc=1; tc<=len; tc++){
            int num = Integer.parseInt(br.readLine().trim());
            nums[tc] = num;
        }

        dp = new int[len+1];

        //1. 첫번째 계단은 1칸이 최댓값
        if(len == 1) dp[1] = nums[1];
        //2. 두번째 계단은 1+1칸이 최댓값
        else if(len == 2) dp[2] = nums[1] + nums[2];

        //3. 세번째 계단, 1+2 or 2+1ß
        else {
            dp[1] = nums[1];
            dp[2] = nums[1] + nums[2];
            dp[3] = Math.max(nums[1]+ nums[3], nums[2] + nums[3]);

            //4번째 계단부터는 연속 3계단이 되면 안되니까, 4계단씩 띄어서 봐야함
            for(int idx=4; idx<len+1; idx++){
                dp[idx] = Math.max(dp[idx-3]+nums[idx]+nums[idx-1], dp[idx-2]+nums[idx]);
            }
        }

        System.out.println(dp[len]);
    }
}

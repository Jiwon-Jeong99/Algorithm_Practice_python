package swea;
/**
 * 뒤에서부터 max값 판별
 * max보다 작으면 차를 더하기
 * max보다 크면 max값 갱신
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1859_백만장자프로젝트 {
    static BufferedReader br;
    static StringTokenizer st;

    static int size; // 전체 길이
    static long max; // 최대값
    static int[] nums;
    static long sum;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=testCase; tc++){
            size = Integer.parseInt(br.readLine().trim());
            nums = new int[size];
            st = new StringTokenizer(br.readLine().trim());
            for(int idx=0; idx<size; idx++){
                nums[idx] = Integer.parseInt(st.nextToken());
            }
            max = 0;
            sum=0;
            for(int num=size-1; num>=0; num--){
                if(nums[num] == size-1){
                    max = nums[num];
                }
                if(nums[num] > max) {
                    max = nums[num];
                    sum += max - nums[num];
                }
                else{
                    sum += max - nums[num];
                }
            }
            System.out.println("#"+tc+" "+sum);
        }

    }
}

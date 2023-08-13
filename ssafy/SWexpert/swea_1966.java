package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class swea_1966 {
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=testCase; tc++){
            br.readLine().trim();
            String[] nums = br.readLine().split(" ");
            int[] ints = new int[nums.length];
            for(int arrIdx=0; arrIdx< nums.length; arrIdx++){
                ints[arrIdx] = Integer.parseInt(nums[arrIdx]);
            }

            Arrays.sort(ints);
            System.out.print("#"+tc+" ");
            for(int idx=0; idx<nums.length; idx++){
                System.out.print(ints[idx] + " ");
            }
            System.out.println();
        }
    }
}

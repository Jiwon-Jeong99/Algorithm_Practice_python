package java_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_6730 {
	static BufferedReader br;
	static StringTokenizer st;
	static int[] nums;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=testCase; tc++) {
			int size = Integer.parseInt(br.readLine().trim());
			st = new StringTokenizer(br.readLine().trim());
			nums = new int[size];
			int upMax = 0;
			int downMax = 0;
			for(int idx=0; idx<size; idx++) {
				nums[idx] = Integer.parseInt(st.nextToken());
			}
			for(int num=0; num<size-1; num++) {
				if(nums[num] < nums[num+1]) upMax = Math.max(upMax, nums[num+1]-nums[num]);
				else if(nums[num] == nums[num+1]) continue;
				else if(nums[num] > nums[num+1]) downMax = Math.max(downMax, nums[num]-nums[num+1]);
			}
			System.out.println("#"+tc+" "+upMax+" "+downMax);
		}
	}
}

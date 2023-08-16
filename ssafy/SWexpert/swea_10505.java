package java_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_10505 {
	static BufferedReader br;
	static StringTokenizer st;
	static int[] nums;
	static int sum;
	static int cnt;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=testCase; tc++) {
			int size = Integer.parseInt(br.readLine().trim());
			st = new StringTokenizer(br.readLine().trim());
			nums = new int[size];
			for(int idx=0; idx<size; idx++) {
				nums[idx] = Integer.parseInt(st.nextToken());
				sum += nums[idx];
			}
			double ave = sum / size;
			for(int num=0; num<size; num++) {
				if(ave >= nums[num]) cnt++;
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}
}

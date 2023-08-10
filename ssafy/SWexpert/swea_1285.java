package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * swea_1285 아름이의 돌 던지기
 * @author 정지원
 *
 */
public class swea_1285 {
	static BufferedReader br;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=testCase; tc++) {
			int people = Integer.parseInt(br.readLine().trim());
			st = new StringTokenizer(br.readLine().trim());
			int min = Integer.MAX_VALUE;
			int cnt= 0;
			int[] nums = new int[people];
			for(int pl=0; pl<people; pl++) {
				nums[pl] = Math.abs(Integer.parseInt(st.nextToken()));
				min = Math.min(min, nums[pl]);
			}
			for(int ct=0; ct<people; ct++) {
				if(nums[ct] == min) cnt++;
			}
			System.out.println("#"+tc+" "+min+" "+cnt);
		}
	}
}

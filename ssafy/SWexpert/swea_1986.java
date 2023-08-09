package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * swea_1986 지그재그 숫자
 * @author 정지원

 */
public class swea_1986 {
	static BufferedReader br;
	static int sum;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=testCase; tc++) {
			int num = Integer.parseInt(br.readLine().trim());
			sum=0;
			for(int idx=1; idx<=num; idx++) {
				if((idx&1) == 1) sum+=idx;
				else sum-=idx;
			}
			System.out.println("#"+tc+" "+sum);
		}
	}
}

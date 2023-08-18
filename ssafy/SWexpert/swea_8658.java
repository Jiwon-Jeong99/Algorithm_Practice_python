package java_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 정지원
 *
 */
public class swea_8658 {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int sum;
	static int max;
	static int min;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			max = 0;
			min = Integer.MAX_VALUE;
			for(int i=0; i<10; i++) {
				String str = st.nextToken();
				sum = 0;
				
				for(int idx=0; idx<str.length(); idx++) {
					sum += str.charAt(idx) - '0';
				}
				max = Math.max(max, sum);
				min = Math.min(min, sum);
			}
			System.out.println("#"+tc+" "+max+" "+min);
		}
	}
}
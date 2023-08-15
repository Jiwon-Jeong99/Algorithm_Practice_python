package java_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * swea_13218 조별과제
 * @author 정지원
 *
 *1. 
 */
public class swea_13218 {
	static BufferedReader br;
	
	static int num; // 학생수
	static int answer; //조의수
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for(int tc=1; tc<=testCase; tc++) {
			num = Integer.parseInt(br.readLine().trim());
			answer = num / 3;
			System.out.println("#"+tc+" "+answer);
		}
	}
}

package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * swea_1984 중간 평균값 구하기
 * @author 정지원
 * 
 * 1. Math.max, Math.min을 찾는다.
 * 2. 전체 sum에서 위의 두 수를 빼고 8을 나눠 평균값을 구한다.
 *
 */
public class swea_1984 {
	static BufferedReader br;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=testCase; tc++) {
			double sum=0;
			double max = 0;
			double min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for(int index=0; index<10; index++) {
				int num = Integer.parseInt(st.nextToken());
				sum += num;
				max = Math.max(max, num);
				min = Math.min(min, num);
			}
			System.out.println("#"+tc+" "+String.format("%.0f", (sum - max - min) / 8));
		}
	}
}

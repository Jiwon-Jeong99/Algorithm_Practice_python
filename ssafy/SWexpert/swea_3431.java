package java_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_3431 {
	static BufferedReader br;
	static StringTokenizer st;
	static int answer;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			int min = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			int now = Integer.parseInt(st.nextToken());
			
			answer = 0;
			if(now < min) answer = min - now;
			else if(min<=now && now<= max) answer = 0;
			else if(now>max) answer = -1;
			System.out.println("#"+tc+" "+answer);
		}
	}
}

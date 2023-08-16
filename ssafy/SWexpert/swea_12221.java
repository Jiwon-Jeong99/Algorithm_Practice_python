package java_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_12221 {
	static BufferedReader br;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int answer = -1;
			if(start <10 && end <10) answer = start * end;
			else answer = -1;
			System.out.println("#"+tc+" "+answer);
		}
	}
}

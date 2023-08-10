package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1976 {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			
			int hour1 = Integer.parseInt(st.nextToken());
			int min1 = Integer.parseInt(st.nextToken());
			int hour2 = Integer.parseInt(st.nextToken());
			int min2 = Integer.parseInt(st.nextToken());
			
			int finalHour = 0;
			int finalMin = 0;
			
			if(12<hour1+hour2) {
				finalHour = hour1+hour2-12;
			}else {
				finalHour = hour1+hour2;
			}
			
			if(min1+min2>59) {
				finalMin = min1+min2-60;
				finalHour++;
			}else {
				finalMin = min1+min2;
			}
			System.out.println("#"+tc+" "+finalHour+" "+finalMin);
		}
	}
}

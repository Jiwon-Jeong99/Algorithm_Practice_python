package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1989 {
	static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=testCase; tc++) {
			String[] str = br.readLine().split("");

			int answer = 1;
			for(int idx=0; idx<(str.length/2)+1; idx++) {
				if(!str[idx].equals(str[(str.length-1)-idx])) {
					System.out.println(str[idx]);
					System.out.println(str[str.length-1-idx]);
					answer=0;
					break;
				}else {
					answer = 1;
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}

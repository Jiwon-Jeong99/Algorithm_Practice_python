package java_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_5601 {
	static BufferedReader br;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=testCase; tc++) {
			int num = Integer.parseInt(br.readLine().trim());
			System.out.print("#"+tc+" ");
			for(int idx=1; idx<=num; idx++) {
				System.out.print("1/"+num+" ");
			}
			System.out.println();
		}
	}
}

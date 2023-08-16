package java_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1217 {
	static BufferedReader br;
	static StringTokenizer st;
	static int many;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1; tc<=10; tc++) {
			br.readLine();
			st = new StringTokenizer(br.readLine().trim());
			int nul = Integer.parseInt(st.nextToken());
			int many = Integer.parseInt(st.nextToken());
			int ans = multiple(nul, many);
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static int multiple(int nul, int many) {
		if(many == 0) {
			return 1;
		}else {
			return nul * multiple(nul, many-1);
		}
	}
}

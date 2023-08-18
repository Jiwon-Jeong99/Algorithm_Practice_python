package java_algo;
/**
 * swea_3260 두수의덧셈
 * 
 * 1. 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class swea_3260_두수의덧셈 {
	static BufferedReader br;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine().trim());

		for(int tc=1; tc<=testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			BigDecimal str1 = new BigDecimal(st.nextToken());
			BigDecimal str2 = new BigDecimal(st.nextToken());
			
			System.out.println("#"+tc+" "+str1.add(str2));
		}
	}
}

package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * swea_1945 간단한 소인수분해
 * @author 정지원
 */
public class swea_1945 {
	static BufferedReader br;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for(int tc=1; tc<=testCase; tc++) {
			int num = Integer.parseInt(br.readLine().trim());
			
			int two = 0;
			int three = 0;
			int five = 0;
			int seven = 0;
			int eleven = 0;
			
			while(num > 1) {
				if(num%2 == 0) {
					two++;
					num = num/2;
				}else if(num%3 == 0) {
					three++;
					num = num/3;
				}else if(num%5==0) {
					five++;
					num=num/5;
				}else if(num%7==0) {
					seven++;
					num=num/7;
				}else if(num%11==0) {
					eleven++;
					num=num/11;
				}
			}
			System.out.println("#"+tc+" "+two+" "+three+" "+five+" "+seven+" "+eleven);
		}
	}
}

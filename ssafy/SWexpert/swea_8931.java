package java_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * swea_8931 제로
 * @author 정지원
 *
 * 1.스택에 수를 말할 때마다 담아놓고
 * 2. 0일때마다 스택에 있는 걸 pop한다.
 * 3. 만약 스택이 비었으면 0을, 아니면 pop하면서 숫자의 합을 구한다.
 * 
 */
public class swea_8931 {
	static BufferedReader br;
	
	static Stack<Integer> stack; //정보를 담는 스택
	static int answer;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=testCase; tc++) {
			int num = Integer.parseInt(br.readLine().trim()); //부른 수 개수
			stack = new Stack<>(); //스택 초기화
			for(int idx=0; idx<num; idx++) {
				int val = Integer.parseInt(br.readLine().trim());
				if(val == 0) {
					stack.pop();
				}else {
					stack.push(val);
				}
			}
			answer = 0;
			for(Integer a:stack) {
				answer += a;
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}
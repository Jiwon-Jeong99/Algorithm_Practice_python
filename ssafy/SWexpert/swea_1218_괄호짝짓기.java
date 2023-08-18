package java_algo;

/**
 * swea_1218 괄호짝짓기
 * 
 * 스택
 * 유효(모든 괄호 짝짓기o) - 1, 유효하지 않음 - 0
 * 
 * 1. 스택에 담긴 것과 순서에 맞게 [],<>,{},() 순서가 맞지 않으면 유효하지 않다고 출력한다.
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class swea_1218_괄호짝짓기 {
	static BufferedReader br;
	static StringTokenizer st;

	static int size; // 괄호 개수
	static char[] total;// 괄호를 담는 스택
	static Stack<Character> stack; // 꺼내서 담아두는 스택
	static int answer; // 유효한지

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			size = Integer.parseInt(br.readLine().trim());
			total = new char[size]; // size만큼 배열 초기화
			total = br.readLine().trim().toCharArray(); // 배열에 괄호들 다 넣기
			answer = 0;

			stack = new Stack<>(); // 스택 초기화

			for (int idx = size - 1; idx >= 0; idx--) {
				if (idx == size - 1) { // 첫번째로 꺼낸 괄호일때
					stack.push(total[idx]);
				} else {
					// 짝이 맞다면
					if (total[idx] == '<' && stack.peek() == '>' || total[idx] == '{' && stack.peek() == '}'
							|| total[idx] == '[' && stack.peek() == ']' || total[idx] == '(' && stack.peek() == ')') {
						stack.pop();
					} else {// 짝이 맞지 않다면 stack에 해당 괄호 추가
						stack.push(total[idx]);
					}
				}
			}

			if (stack.empty())
				answer = 1;
			System.out.println("#" + tc + " " + answer);
		}
	}
}

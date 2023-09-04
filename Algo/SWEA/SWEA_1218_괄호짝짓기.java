package swea;
/**
 * swea_1218 괄호짝짓기
 *
 * 문제
 * 1. 괄호의 짝이 맞는지 판단
 * 2. 짝이 맞으면 - 1 / 짝이 안맞으면 - 0
 *
 * 문풀
 * 1. 스택을 1개 만든다.
 * 2. 스택에 만약 스택의 끝 인덱스와 받은 문자열 스택이 짝이 맞지 않으면 0을 출력한다.
 * 3. 만약 다른 스택의 길이가 0이 되면 1을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class SWEA_1218_괄호짝짓기 {
    static BufferedReader br;

    static char[] mainArr;
    static Stack<Character> subStack;
    static int answer;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=1; tc<=10; tc++){
            int length = Integer.parseInt(br.readLine().trim());
            mainArr = br.readLine().trim().toCharArray();
            subStack = new Stack<>();

            //초기값 집어넣기
            subStack.add(mainArr[length-1]);

            //초기값 제외하고 비교해서 집어넣기
            for(int idx=length-2; idx>=0; idx--){
                checkBracket(mainArr[idx]);
            }

            if(subStack.isEmpty()) answer = 1;
            else answer = 0;

            System.out.println("#"+tc+" "+answer);
        }
    }

    static void checkBracket(char bracket) {
        if(bracket == '[' && subStack.peek() == ']' || bracket == '<' && subStack.peek() =='>' || bracket == '(' && subStack.peek() == ')' || bracket == '{' && subStack.peek() == '}') subStack.pop();
        else {
            subStack.push(bracket);
        }
    }
}


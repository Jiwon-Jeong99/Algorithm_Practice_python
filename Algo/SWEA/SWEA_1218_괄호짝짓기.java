package swea;
///**
// * swea_1218 괄호짝짓기
// *
// * 문제
// * 1. 괄호의 짝이 맞는지 판단
// * 2. 짝이 맞으면 - 1 / 짝이 안맞으면 - 0
// *
// * 문풀
// * 1. 스택을 1개 만든다.
// * 2. 스택에 만약 스택의 끝 인덱스와 받은 문자열 스택이 짝이 맞지 않으면 0을 출력한다.
// * 3. 만약 다른 스택의 길이가 0이 되면 1을 출력한다.
// */
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Stack;
//
//public class SWEA_1218_괄호짝짓기 {
//    static BufferedReader br;
//
//    static char[] mainArr;
//    static Stack<Character> subStack = new Stack<>();
//    static int answer;
//    public static void main(String[] args) throws IOException {
//        br = new BufferedReader(new InputStreamReader(System.in));
//
//        for(int tc=1; tc<=10; tc++){
//            int length = Integer.parseInt(br.readLine().trim());
//            mainArr = br.readLine().trim().toCharArray();
//
//            //초기값 집어넣기
//            subStack.add(mainArr[length-1]);
//
//            //초기값 제외하고 비교해서 집어넣기
//            for(int idx=length-2; idx>=0; idx--){
//                checkBracket(mainArr[idx]);
//            }
//
//            if(subStack.isEmpty()) answer = 1;
//            else answer = 0;
//
//            System.out.println("#"+tc+" "+answer);
//        }
//    }
//
//    static void checkBracket(char bracket) {
//        if(bracket == '[' && subStack.peek() == ']' || bracket == '<' && subStack.peek() =='>' || bracket == '(' && subStack.peek() == ')' || bracket == '{' && subStack.peek() == '}') subStack.pop();
//        else {
//            subStack.push(bracket);
//        }
//    }
//}

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

public class SWEA_1218_괄호짝짓기 {
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

            if (stack.isEmpty())
                answer = 1;
            System.out.println("#" + tc + " " + answer);
        }
    }
}
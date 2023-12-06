package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * boj_17413_단어뒤집기2
 * <></>인거는 태그여서 건들지 말고, 그 사이에 있거나 문자열인 경우에만 뒤집기
 */

public class BOJ_17413_단어뒤집기2 {
    static BufferedReader br;
    static StringBuilder sb;

    static boolean flag = false; //<> 유무 판별을 위한 flag
    static Stack<Character> stack; //문자를 담을 스택

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        stack = new Stack<>();

        //1. 문자열 입력받기
        String str = br.readLine().trim();

        //2. str를 순회하면서 <>만나면 그냥 바로 sb에 넣고, 아니면 stack에 넣기
        for(int idx=0; idx<str.length(); idx++){
            //<라면
            if(str.charAt(idx) == '<'){
                while(!stack.isEmpty()){
                    sb.append(stack.pop()); //그전꺼 sb에 추가
                }
                flag = true;
            }

            //>라면
            else if(str.charAt(idx) == '>'){
                sb.append(str.charAt(idx)); //>sb에 추가
                flag = false;
                continue;
            }

            //flag = true면, 그대로 sb에 추가
            if(flag == true) {
                sb.append(str.charAt(idx));
            }

            //flag = false면, stack에 넣어서 거꾸로 sb에 추가
            else if(flag == false) {
                //문자가 공백이면, 모든 stack 원소 pop해서 sb에 추가
                if(str.charAt(idx) == ' '){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                    continue;
                }
                else {
                    stack.push(str.charAt(idx));
                }
            }

            //마지막 str 원소에서 스택이 비어있지 않으면 sb에 추가
            if(idx == str.length() - 1){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
            }
        }

        System.out.println(sb);
    }
}

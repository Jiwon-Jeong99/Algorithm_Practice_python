/**
문제
1. ()이렇게 짝지어져야 괄호가 바르게 짝지어졌다.
2. 문자열 s가 올바른 괄호이면 true, 아니면 false return

문풀
1. char[]에 문자열을 파싱해서 넣는다. -> character
2. 스택에 나온 문자열을 저장해놓고 만약 배열에서 뽑은 char랑 ()가 맞으면 없애기
3. 만약 다른게 나오면 false 바로 return

=> 이렇게 풀면 효율성테스트 2번에서 시간초과남(아마 스택에 char를 넣고 빼는 과정에서 발생하는 듯)
*/

import java.util.*;

class Solution {
    Stack<Character> stack = new Stack<>();
    
    boolean solution(String s) {
        boolean answer = true; //정답 초기값
        
        //inputArr의 첫번째 값은 바로 스택에 넣기
        stack.add(s.charAt(0));
        
        //inputArr에서 for문으로 순회하면서 스택에 넣기
        for(int idx=1; idx<s.length(); idx++){
            if(!stack.isEmpty() && stack.peek() == '(' && s.charAt(idx) == ')'){
                stack.pop();
            }else if(!stack.isEmpty() && stack.peek() == ')' && s.charAt(idx) == '('){
                answer = false;
                break;
            }else {
                stack.add(s.charAt(idx));
            }
        }
        
        //만약 순회했는데도 스택에 남아있다면, answer = false
        if(answer && !stack.isEmpty()) answer = false;

        return answer;
    }
}

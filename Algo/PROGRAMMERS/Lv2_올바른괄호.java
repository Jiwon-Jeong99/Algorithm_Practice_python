/**
스택
(로 시작했으면 )로 닫혀야됨
s가 올바른 괄호 -> true
올바르지 않은 괄호 -> false
*/

import java.util.*;
import java.io.*;

class Solution {
    
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        
        if(s.charAt(0) == ')') return false;
        
        for(int idx=0; idx<s.length(); idx++){
            if(!stack.isEmpty() && s.charAt(idx) == ')') stack.pop();
            else stack.push(s.charAt(idx));
        }
        
        //스택이 비어있으면 모든 괄호가 짝지어져 있으면 true, 아니면 false
        answer = (stack.isEmpty()) ? true : false;
        
        return answer;
    }
}

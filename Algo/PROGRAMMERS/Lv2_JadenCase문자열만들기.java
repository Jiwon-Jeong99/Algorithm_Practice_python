import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        //전체를 먼저 소문자로 만든다.
        String[] str = s.toLowerCase().split("");
        //이전이 공백인지 체크
        boolean space = true;
        
        for(String ss : str){
            if(space){
                answer += ss.toUpperCase();
            }else{
                answer += ss;
            }
            
            if(ss.equals(" ")) space = true;
            else space = false;
        }
        
        return answer;
    }
}

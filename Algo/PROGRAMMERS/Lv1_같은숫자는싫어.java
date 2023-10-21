/**
연속적으로 나타나는 숫자 하나만 남기고 전부제거
순서 유지하기

*/
import java.util.*;

public class Solution {
    
    static List<Integer> list;
    
    public int[] solution(int []arr) {
        int len = arr.length;
        list = new ArrayList<>();
        
        int value = -1;
        
        for(int idx=0; idx<len; idx++) {
            if(arr[idx] != value){
                list.add(arr[idx]);
                value = arr[idx];
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}

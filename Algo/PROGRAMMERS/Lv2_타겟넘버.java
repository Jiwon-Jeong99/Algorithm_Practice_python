/**
순서대로 더하거나 빼서 타겟넘버를 만들어라

문풀
dfs로 이진트리의 단말노드까지 각각 가면서 target넘버랑 같은지 확인해본다.
*/

import java.util.*;
import java.io.*;

class Solution {
    int count = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        
        return count;
    }
    
    public void dfs(int[] numbers, int depth, int target, int result){
        if (depth == numbers.length){ //마지막 노드까지 진행했을 때
            if (target == result){ //target값과 합계가 같다면
                count++;
            }
            return;
        }
        
        int plus = result + numbers[depth]; //양수를 더한 값
        int minus = result - numbers[depth]; //음수를 더한 값
        // System.out.println("몇번째야?"+depth+" "+result);
        dfs(numbers, depth+1, target, plus);
        dfs(numbers, depth+1, target, minus);
        
    }
    
}

/**
i~j번째 숫자까지 자르고 정렬할때, k번째에 있는 수 -> index+1
i,j,k

1. 원본배열 복사
2. 해당 수 더하기
*/

import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        System.out.println(commands.length);
        
        for(int idx=0; idx<commands.length; idx++){
            int startIdx = commands[idx][0]-1;
            int endIdx = commands[idx][1];
            int index = commands[idx][2]-1;
            
            int[] copyArr = Arrays.copyOfRange(array, startIdx, endIdx);
            Arrays.sort(copyArr);
            answer[idx] = copyArr[index];
        }
        
        return answer;
    }
}

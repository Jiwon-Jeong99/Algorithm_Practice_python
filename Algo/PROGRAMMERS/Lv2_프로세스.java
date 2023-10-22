/**
- 우선순위 큐 

*/

import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] priorities, int location) {
        //우선순위 큐 선언(내림차순)
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        
        //우선순위 큐에 우선순위 요소 추가
        for(int idx : priorities){
            queue.offer(idx);
        }
        
        //큐가 빌때까지 반복
        while(!queue.isEmpty()){
            //기존 우선순위 배열 순회
            for(int idx=0; idx<priorities.length; idx++){
                //현재 작업의 위치 찾기
                if(queue.peek() == priorities[idx]){
                    queue.poll();
                    answer++;
                    
                    if(location == idx) return answer;
                }
            }
        }
        return answer;
    }
}

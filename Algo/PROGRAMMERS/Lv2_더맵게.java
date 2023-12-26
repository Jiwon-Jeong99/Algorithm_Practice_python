/**
문제
1. 모든 음식의 스코빌 지수 K이상
2. 이를 위해서는 -> 
섞은 음식의 스코빌 지수 = 가장 안 매운 음식의 스코빌 지수 + (두 번째로 안 매운 음식의 스코빌 지수 * 2)
3. 스코빌 지수가 K이상이 될 때까지 반복
4. 섞어야 하는 최소 횟수 return 
5. 모든 스코빌 지수 K이상 불가능 -> -1 return 

문풀
1. 100만 이상이 주어지기 때문에 완탐은 안됨
2. 이 경우 우선순위큐(aka. heap)를 사용해서 최소로 섞는 횟수를 return 해야함
O(logn)
*/

import java.util.*;
import java.io.*;

class Solution {
    static PriorityQueue<Integer> queue = new PriorityQueue<>();
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        //1. 최소힙에 인덱스값 넣어주기
        for(int idx=0; idx<scoville.length; idx++){
            queue.add(scoville[idx]);
        }
        
        //2. 최소가 K보다 작으면 섞기
        while(queue.peek() < K){
            if(queue.size() == 1) return -1; //큐에 남은게 하나라면
            queue.add(queue.poll() + queue.poll() * 2);
            answer++;
        }
        
        return answer;
    }
    
    
}

/**
output : 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는가

- 트럭 최대 : bridge_length대
- 트럭 무게 : weight 이하

1. 큐가 비어있는 경우
2. 큐가 다리 길이만큼 가득 차지 않은 경우
3. 큐가 가득 찬 경우
*/

import java.util.*;
import java.io.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0; //걸리는 시간
        int sum = 0; //다리에 올라간 무게 총합
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int idx=0; idx<truck_weights.length; idx++){
            int truck = truck_weights[idx]; //트럭 무게
            
            while(true){
                //1. 큐가 비어있는 경우 = 어떤 트럭도 다리에 없음
                if(queue.isEmpty()) {
                    queue.add(truck);
                    sum += truck;
                    time++; //다리에 오를때만 시간 추가
                    break;
                } else if (queue.size() == bridge_length) { //큐에 다리 길이만큼 트럭 다 찬 경우
                    sum -= queue.poll();                    
                } else { //다리 길이만큼 큐가 차지 않았을 때
                    //weight 값을 넘지 않는 선에서 새로운 트럭을 다리에 올려줌
                    if(sum + truck <= weight){
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    }else {
                        //무게가 넘는다면 0을 넣어서 이미 큐에 있는 트럭이 다리를 건너도록
                        queue.add(0);
                        time++;
                    }
                }
            }
        }
        //마지막 트럭에서 다리 길이만큼 지나가야 하기 떄문에
        return time + bridge_length;
    }
}

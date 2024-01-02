/**
문제
1. 구명보트 한번에 2명 + 무게제한
2. 몸무게 배열 people, 무게제한 limit
=> 모든 사람 구출 위한 '최소' 구명보트 개수

문풀
완탐으로 nC2하면 50000이기 때문에 시간초과남
1. 배열 오름차순
2. 최댓값과 최솟값을 더해서 limit를 넘지 않는지 확인
3. 넘지 않는다면 없애고, 넘는다면 최댓값만 없애고 count++
*/

import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] people, int limit) {
        //배열 오름차순
        Arrays.sort(people);
        
        int answer = 0;
        int arrow = 0; //최솟값 위치
        
        //최댓값부터 비교
        for(int idx=people.length -1; idx>=arrow; idx--){
            if(people[idx] + people[arrow] > limit){//무게초과
                answer++;
            }else{
                answer++;
                arrow++;
            }
        }
        
        return answer;
    }
}

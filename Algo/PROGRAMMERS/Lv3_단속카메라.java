/**
문제
1. 단속용 카메라를 한번은 만나게 카메라 설치
=> 최소 몇대의 카메라를 설치해야 하는가

문풀
1. 원래는 -30000~30000이라 그냥 완탐으로 할까 했지만 겹치는 부분에 놓으면 되겠다는 생각을 했다.
2. 배열 오름차순[1] 기준으로
3. 처음엔 [i][1]에 놓기
4. 그다음 start[i][0]가 전에 놓은 위치보다 멀면 [i][1]에 놓기
5. 일단 해보기
*/

import java.util.*;
import java.io.*;

class Solution {
    int camera;
    int answer;
    
    public int solution(int[][] routes) {
        //[i][1]기준으로 sort
        Arrays.sort(routes, (o1,o2) -> o1[1]-o2[1]);
        //처음엔 놓기
        camera = routes[0][1];
        answer = 1;
        
        //배열 순회하면서 카메라 위치 확인
        for(int idx=1; idx<routes.length; idx++){
            if(camera < routes[idx][0]){
                answer++;
                camera = routes[idx][1];
            }
        }
        
        return answer;
    }
}

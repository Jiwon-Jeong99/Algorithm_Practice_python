/**
문제
1. 탐험시작을 위한 '최소 필요 피로도'
   탐험을 마쳤을 때 소모되는 '소모 피로도'
2. 현재 피로도 k
[최소 필요 피로도, 소모 피로도]

=> 유저가 탐험할 수 있는 최대 던전 수 return 

문풀
1. 순열로 던전 순서를 정하기
2. 순서마다 갈 수 있는 최대 던전수 업데이트하기
//프로그래머스는 class안에 static으로 선언하기 어려우니까 그냥 매개변수로 주자
*/

import java.util.*;
import java.io.*;

class Solution {
    int answer = -1; //최대 던전 수
    boolean[] visited; //방문 여부
    int[] selected; //선택된 배열

    public int solution(int k, int[][] dungeons) {
        //dungeons 배열의 길이만큼 방문 여부 배열 선언
        visited = new boolean[dungeons.length];
        selected = new int[dungeons.length];

        //순열 메서드 
        permutation(0, k, dungeons);

        return answer;
    }

    //순영ㄹ
    public void permutation(int depth, int k, int[][] dungeons) {
        if(depth == dungeons.length){
            int cnt = 0; //던전개수
            for(int idx=0; idx<selected.length; idx++){
                
                //피로도가 남아있으면
                if(k >= dungeons[selected[idx]][0]){
                    k -= dungeons[selected[idx]][1];
                    cnt++;
                }
                else break; //피로도가 남아있지 않으면 break
            }
            answer = Math.max(answer, cnt);
            return;
        }
        
        for(int idx=0; idx<dungeons.length; idx++){
            if(!visited[idx]){
                visited[idx] = true;
                selected[depth] = idx;
                permutation(depth+1, k, dungeons);
                visited[idx] = false;
            }
        }
    }
}

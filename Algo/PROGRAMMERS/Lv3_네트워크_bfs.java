/**
문제
1. 컴퓨터 개수 n, 연결정보 2차원 배열 computers
=> 네트워크 개수 return (직접적 or 간접적 연결)

문풀
1. bfs/dfs로 노드 탐색
2. for문을 사용해 노드를 순회하면서 다른노드도 탐색
3. 만약 방문하지 않은 노드가 있다면 네트워크 count++
*/

import java.util.*;
import java.io.*;

class Solution {
    static boolean visited[]; //방문체크배열
    static Queue<Integer> queue = new ArrayDeque<>();
    static final int CONNECT = 1;
    
    public int solution(int n, int[][] computers) {
        int answer = 0; //네트워크 개수
        visited = new boolean[n];
        
        //for문으로 모든 노드를 하나씩 탐색
        for(int idx=0; idx<n; idx++){
            if(!visited[idx]){
                bfs(idx, n, computers);
                answer++;
            }
        }
        return answer;
    }
    
    //bfs
    public void bfs(int idx, int n, int[][] computers){
        queue.offer(idx);
        visited[idx] = true; //방문처리
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            
            for(int num=0; num<n; num++){
                //아직 노드를 방문하지 않았고, 1로 연결되어 있다면
                if(!visited[num] && computers[node][num] == CONNECT){
                    visited[num] = true; //방문처리
                    queue.offer(num); //queue에 넣기
                }
            }
        }
    }
}

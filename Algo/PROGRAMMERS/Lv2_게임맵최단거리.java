/**
- (1,1)에서 시작
- 동서남북
- 0 : 벽, 1 : 벽이 없는 자리

output : 최소값으로 도착 or 도착하지 못하면 -1 
*/

import java.util.*;

class Solution {
    
    //상하좌우
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static final int DELTA = 4;
    
    int[][] visited;
    int answer = 0;
    
    static Queue<Pos> queue;
    
    static int row, col;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        row = maps.length;
        col = maps[0].length;
        
        visited = new int[row][col];
        
        visited[0][0] = 1;
        
        bfs(0,0, maps);
        //도착지 값 넣어주기
        answer = visited[row-1][col-1];
        
        //갈수 없으면 -1리턴
        if(answer == 0) answer = -1;
        
        return answer;
    }
    
    public void bfs(int startX, int startY, int[][] maps) {
        queue = new ArrayDeque<>();
        
        queue.offer(new Pos(startX,startY));
        
        while(!queue.isEmpty()){
            Pos pos = queue.poll();
            
            int x = pos.x;
            int y = pos.y;
            
            for(int idx=0; idx<DELTA; idx++){
                int nx = x + dx[idx];
                int ny = y + dy[idx];
                
                if(nx < 0 || ny < 0 || nx >= row || ny >= col || visited[nx][ny] != 0 || maps[nx][ny] == 0) continue;
                
                //방문했다고 넣어주기
                visited[nx][ny] = visited[x][y] + 1;
                
                queue.add(new Pos(nx, ny));
            }
            
        }
        
        
    }
    
    public class Pos {
        int x,y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

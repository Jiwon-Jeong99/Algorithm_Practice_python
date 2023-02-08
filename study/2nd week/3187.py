import sys
from collections import deque

input = sys.stdin.readline
r,c = map(int,input().rstrip().split())

land = []

visited = [[0]*c for _ in range(r)]

#visited
for _ in range(r):
    land.append(list(input().rstrip()))
    
def bfs(x,y):
    global wolf, sheep
    q = deque()
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    visited[x][y] = 1
    q.append([x,y])
    
    while q:
        x,y = q[0][0], q[0][1]
        del q[0]
        
        #늑대 증가
        if land[x][y] == "v":
            wolf+=1
        #양 증가
        elif land[x][y] =="k":
            sheep +=1
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0<= nx <r and 0 <= ny < c and land[nx][ny] !="#" and visited[nx][ny] ==0:
                q.append([nx,ny])
                visited[nx][ny] = 1
    
total_wolf = 0
total_sheep = 0

for i in range(r):
    for j in range(c):
        if land[i][j] != "#" and visited[i][j] == 0:
            wolf=0
            sheep=0
            bfs(i,j)
            if wolf>=sheep:
                sheep=0
            else:
                wolf=0
            total_wolf +=wolf
            total_sheep +=sheep
print(total_sheep, total_wolf)
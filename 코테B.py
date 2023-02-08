from collections import deque
import sys

def bfs(x,y):
    global count
    if(visited[x][y]==1):
        return 
    count+=1
    q=deque()
    q.append((x,y))
    while q:
        x,y=q.pop()
        visited[x][y]=1
        dx=[-1,1,0,0]
        dy=[0,0,-1,1]
        for i in range(4):
            X=(x+dx[i])%n
            Y=(y+dy[i])%m
            if not visited[X][Y] and metrix[X][Y]==0:
                q.append((X,Y))
            
n,m=map(int, sys.stdin.readline().split())
count=0
metrix=[]
visited=[[0 for _ in range(m)]for _ in range(n)]
for _ in range(n):
    metrix.append(list(map(int, sys.stdin.readline().split())))
for x in range(n):
    for y in range(m):
        if metrix[x][y]==0 and not visited[x][y]:
            bfs(x,y)
print(count)
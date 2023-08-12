import sys
from collections import deque

T = int(sys.stdin.readline().rstrip())
    
def bfs() :
    dx = [-1, 1, 2, 2, 1, -1, -2, -2]
    dy = [2, 2, 1, -1, -2, -2, -1, 1]

    q = deque()
    q.append((curX, curY))
    while q :
        x, y = q.popleft()
        if x == endX and y == endY :
            return chess[x][y] -1 
        for i in range(8) :
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<l and 0<=ny<l and chess[nx][ny] == 0 :
                chess[nx][ny] = chess[x][y] + 1
                q.append((nx,ny))

for _ in range(T):
    I = int(sys.stdin.readline().rstrip())
    curX, curY = map(int, sys.stdin.readline().rstrip().split())
    endX, endY = map(int, sys.stdin.readline().rstrip().split())
    chess = [[0]*I for _ in range(I)]
    chess[curX][curY] = 1
    print(bfs())
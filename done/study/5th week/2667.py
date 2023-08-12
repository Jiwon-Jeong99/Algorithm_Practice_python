import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
answer = []
graph = []
# 배열 입력
for _ in range(n):
    graph.append(list(map(int,list(input().rstrip()))))
    
# 이동방향
dx = [0,0,1,-1]
dy = [1,-1,0,0]

visited = [[0]*n for _ in range(n)]

def bfs(x,y):
    q = deque()
    q.append((x,y))
    
    cnt=1
    
    while q:
        x,y = q.popleft()
        visited[x][y] = 1
        #현재 위치에서 4가지 방향으로의 위치 확인
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 공간 벗어난 경우 무시하고 공간일 경우만 진행
            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            # 벽인 경우 무시
            if graph[nx][ny] == 0:
                continue
            # 해당 노드를 처음 방문하는 경우에만 기록
            if graph[nx][ny] == 1:
                if visited[nx][ny] == 0: #visited 0,1은 지들끼리 돌때 따로
                    graph[nx][ny] = graph[x][y] + 1
                    q.append((nx,ny))
                    cnt += 1
    if cnt != 0:
        answer.append(cnt)

def start():
    for i in range(n):
        for j in range(n):
            if graph[i][j] == 1 and visited[i][j] == 0:
                bfs(i,j)

start()
print(len(answer))
answer.sort()
for i in range(len(answer)):
    print(answer[i])


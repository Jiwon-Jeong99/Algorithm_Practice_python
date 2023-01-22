import sys
from collections import deque

deq = deque()

n,m = map(int, sys.stdin.readline().split())
for _ in range(n):
    line = list(map(int, sys.stdin.readline().split()))
    deq.append(line)

# 가로로 정렬 넘기기
for i in range(m):
    if deq[0][i] == 0 and deq[1][i] == 0:
        height1 = deq.popleft()
        deq.append(height1)
        height2 = deq.popleft()
        deq.append(height2)
        print(deq)
print(deq)

# for k in range(n):
#     for x in range(m-1):
#         if deq[k][x] == 0 and deq[k][x+1] == 0:
            
# 최종 deq이 나오면
def dfs(x, y):
    if x <= -1 or x >= n or y <= -1 or y >= m:
        return False
    
    if deq[x][y] == 0:
        deq[x][y] = 1
        dfs(x, y + 1)
        dfs(x, y - 1)
        dfs(x + 1, y)
        dfs(x - 1, y)
        return True
    return False

result = 0
for i in range(n):
    for j in range(m):
        if dfs(i, j) == True:
            result += 1

print(result)  

# import sys
# from collections import deque
# input = sys.stdin.readline

# f,s,g,u,d = map(int,input().split().rstrip())

# graph = []

# # 이동방향
# dy = [u, -d]

# visited  = [[] for _ in range()]
# def bfs(x):
#     q = deque()
    
#     cnt = 0
    
#     while q:

from collections import deque
 
def bfs(x):
 
    queue = deque()
    queue.append(s)
    visited[s] = 1
 
    updown = [u, -d]
    while queue:
        a = queue.popleft()
        
        # 도착했다면
        if a == g:
            return visited[a] - 1
 
        for i in updown:
            if 0 < a + i < f + 1:
                if visited[a + i]:
                    continue
                queue.append(a + i)
                visited[a + i] = visited[a] + 1
 
    return "use the stairs"
 
f, s, g, u, d = map(int, input().split())
visited = [0] * (f + 1)
print(bfs(s))

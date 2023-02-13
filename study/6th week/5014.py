import sys
from collections import deque
input = sys.stdin.readline

f,s,g,u,d = map(int,input().split().rstrip())

graph = []

# 이동방향
dy = [u, -d]

visited  = [[] for _ in range()]
def bfs(x):
    q = deque()
    
    cnt = 0
    
    while q:
        
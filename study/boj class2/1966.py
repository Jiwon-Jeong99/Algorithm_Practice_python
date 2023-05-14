import sys
from collections import deque

input = sys.stdin.readline
t = int(input())
for _ in range(t):
    n, m = map(int,input().split())
    q = deque(list(map(int, input().split())))
    
    count = 0
    my = q[m]
    while my in q:
        if q[0] != max(q):
            q.append(q[0])
            q.popleft()
        else:
            q.popleft()
            count += 1
    print(count)
        
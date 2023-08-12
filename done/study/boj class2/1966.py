# error
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
        if m == 0 and q[0] == max(q):
            count += 1
            break
        elif m == 0 and q[0] != max(q):
            m = len(q) - 1
            q.append(q[0])
            q.popleft()
        elif m != 0 and q[0] != max(q):
            q.append(q[0])
            q.popleft()
            m -= 1
        else:
            q.popleft()
            count += 1
    print(count)

# import sys
# from collections import deque

# input = sys.stdin.readline
# t = int(input())
# for _ in range(t):
#     n, m = map(int,input().split())
#     q = deque([(i, int(s)) for i, s in enumerate(input().split())])

#     count = 0
#     my = q[m]

#     while my in q:
#         idx, v = q.popleft()
#         count += 1

#         if not q:
#             break
        
#         max_ = max(q, key=lambda x: x[1])[1]
#         if v < max_:
#             q.append((idx, v))
#             count -= 1
#         elif v == max_:
#             continue

#     print(count)
import sys
from collections import deque

# n: 사람 수, k: 최대 등수차이
n, k = map(int, sys.stdin.readline().split())
# 이름의 길이만 name_len큐에 담는다.
name_len = deque()
for _ in range(n):
    name_len.append(sys.stdin.readline())

# 비교하는 큐 
compare = deque()
# 친한 친구 쌍 숫자
cnt = 0
if len(name_len) != 0:
    while name_len:
        compare.append(name_len.popleft())
    
        count = compare.count(compare[0])
        cnt += count - 1
else:
    






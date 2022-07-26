import sys
from collections import deque

# n: 사람 수, k: 최대 등수차이
n, k = map(int, sys.stdin.readline().split())
# 이름의 길이만 name_len큐에 담는다.
name_len = deque()
for _ in range(n):
    name_len.append(sys.stdin.readline())

print(name_len)



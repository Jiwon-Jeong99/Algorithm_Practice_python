import sys
from collections import deque

# total: 트럭 수, length: 다리 길이, weight: 다리 최대하중
total, length, weight = map(int, sys.stdin.readline().split())
trucks = deque(map(int, sys.stdin.readline().split()))

time = 0
# 다리 길이만큼 공간 만들기
bridge = deque([0]*length)

# trucks에 있는 엘리먼트가 없어질 때까지
while trucks:
    bridge.popleft()
    # trucks의 첫 번째 트럭 무게
    x = trucks[0]
    # bridge에 할당된 남은 자리 < 다리 길이 , 다리 위에 놓여진 트럭 무게+지금 트럭무게 <= 다리 최대하중
    if len(bridge) < length and sum(bridge) + x <= weight:
        bridge.append(trucks.popleft())
    else:
        bridge.append(0)
    time += 1
print(time + length)


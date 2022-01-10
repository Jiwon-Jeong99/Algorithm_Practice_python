#deque 라이브러리를 사용하고 리스트 형태가 아니라서 reverse() 사용가능
from collections import deque

queue = deque()

queue.append(5)
queue.append(2)
queue.append(3)
queue.append(7)

print(queue)
queue.popleft()
print(queue)

queue.append(1)
queue.append(4)
print(queue)

queue.popleft() #deque에서는 popleft를 써야함 (선입후출이 됨)
print(queue)

queue.reverse()
print(queue)
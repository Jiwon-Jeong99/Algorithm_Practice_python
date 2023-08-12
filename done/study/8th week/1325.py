import sys
from collections import deque
input = sys.stdin.readline

N,M = map(int, input().split())

def bfs(start):
    cnt = 1
	queue = deque([start])
	visit = [False for _ in range(N+1)]
	visit[start] = True

	while queue:
		cur = queue.popleft()

		for nx in graph[cur]:
			if not visit[nx]:
				visit[nx] = True
				cnt += 1
				queue.append(nx)

	return cnt

graph = [[] for _ in range(n+1)]
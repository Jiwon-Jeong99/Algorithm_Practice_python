import sys

input = sys.stdin.readline
n, m, b = map(int, input().split())

land = []
for _ in range(n):
    l = list(map(int, input().split()))
    land.append(l)

time = 0

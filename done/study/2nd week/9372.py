import sys

T = int(sys.stdin.readline().rstrip())


for _ in range(T):
    n,m = map(int, sys.stdin.readline().split()) #국가의 수:n, 비행기 종류:m
    airplane_list = [[] for _ in range(n+1)]
    for _ in range(m):
        a,b = map(int, sys.stdin.readline().split())
    print(n-1)
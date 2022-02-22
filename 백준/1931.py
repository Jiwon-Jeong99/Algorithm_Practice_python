import sys

n = int(sys.stdin.readline())
time_list=[]
for i in range(n-1):
    a,b = map(int,sys.stdin.readline().split())
    time_list.append([a,b])


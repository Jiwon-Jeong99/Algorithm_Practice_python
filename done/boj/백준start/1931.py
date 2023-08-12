import sys

n = int(sys.stdin.readline())
time_list=[]
for i in range(n-1):
    start,end = map(int,sys.stdin.readline().split())
    time_list.append([start,end])


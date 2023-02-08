import sys

n = int(sys.stdin.readline())
a = list(map(int, sys.stdin.readline().split()))

count = []
for i in range(24):
    count.append(0)

for i in range(n):
    count[a[i]] += 1

for i in range(1,24):
    print(count[i],end=' ')


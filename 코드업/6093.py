import sys

n = int(sys.stdin.readline())
k = list(map(int,sys.stdin.readline().split()))

'''
for i in range(n-1,-1,-1):
    print(k[i],end=' ')
'''

print(k[::-1], end=' ')


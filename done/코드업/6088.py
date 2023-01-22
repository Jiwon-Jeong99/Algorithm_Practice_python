import sys

a,d,n = map(int,sys.stdin.readline().split())

final = a+(n-1)*d
print(final)
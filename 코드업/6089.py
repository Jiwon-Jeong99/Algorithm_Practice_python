import sys

a,r,n = map(int, sys.stdin.readline().split())

final = a * r **(n-1)
print(final)
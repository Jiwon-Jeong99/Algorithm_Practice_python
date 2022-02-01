import sys

a,b = map(int,sys.stdin.readline().split())

c = (a if(a>=b) else b)
print(int(c))
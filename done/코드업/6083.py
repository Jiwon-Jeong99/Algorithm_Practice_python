from re import A
import sys

r,g,b = map(int,sys.stdin.readline().split())

a=0
for i in range(0,r):
    for j in range(0,g):
        for k in range(0,b):
            a += 1
            print(i,j,k)

print(a)
import sys

a,b,c = map(int,sys.stdin.readline().rstrip().split())

sum = a+b+c
average = round(sum/3, 2)

print(sum, average)
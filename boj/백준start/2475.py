import sys

a,b,c,d,e = map(int,sys.stdin.readline().split())

#a의 b승 => a**b
answer = (a**2+b**2+c**2+d**2+e**2) % 10

print(answer)
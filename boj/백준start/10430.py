import sys

a,b,c = map(int,sys.stdin.readline().split())

x = (a+b)%c
y = ((a%c)+(b%c))%c
z = (a*b)%c
w = ((a%c)*(b%c))%c

print(x)
print(y)
print(z)
print(w)
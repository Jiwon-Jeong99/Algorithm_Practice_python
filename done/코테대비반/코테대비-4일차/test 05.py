import sys
b = sys.stdin.readline()
a = list(b)

print(a)

n = 0
num = 10
while len(a)-1 > n:
    if a[n] == a[n+1]:
        num += 5
        n += 1
        print(num)
    elif a[n] != a[n+1]:
        num += 10
        n += 1
        print(num)
print(num)

import sys

a = int(sys.stdin.readline())

total =0
for i in range(2,a+1,2):
    total += i
print(total)

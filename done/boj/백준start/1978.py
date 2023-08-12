import sys

n = int(sys.stdin.readline())
numbers = map(int,sys.stdin.readline().split())

# 소수 구하기 - 에라토스테네스의 체
sosu = 0
for num in numbers:
    if num > 1:
        for i in range(2,num): #2~n-1까지
            if num % i == 0:
                break
        else:
            sosu += 1
print(sosu)
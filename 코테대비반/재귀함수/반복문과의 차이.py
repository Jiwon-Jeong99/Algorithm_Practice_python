#반복문
n=10
def factorial(n):
    sum=1
    for i in range(1,n+1):
        sum *= i
    return sum

print(factorial(10))

#재귀함수
def facto(n):
    if n==0:
        return 1
    else:
        return n*facto(n-1)

print(facto(10))
n = int(input())

count=0
memo=[0]*100

def fibo(n):
    global count

    if n==1 or n==2: # 지정한 값
        count += 1
        memo[n] = 1 #위치에 값 1을 삽입
    
    if memo[n] != 0: #계산했다면
        count += 1
        return memo[n]

    count += 1
    value= fibo(n-1)+fibo(n-2)
    memo[n]=value

    return value

print("fibo(n):",fibo(n))
print("count:",count)
print("memo:",memo)
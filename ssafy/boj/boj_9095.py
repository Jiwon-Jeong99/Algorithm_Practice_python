'''
1. f(n) = f(n-1)+f(n-2)+f(n-3)까지의 개수의 합
2. list가 out of range되지 않게 미리 리스트 길이에 맞게 만들어놓기
3. dp로 풀기

'''

import sys

input = sys.stdin.readline

test_case = int(input())

def dp(num):
    dp_arr = [0] * (num+1)
    
    dp_arr.insert(0,0)
    dp_arr.insert(1,1)
    dp_arr.insert(2,2)
    dp_arr.insert(3,4)
    
    if num > 3:
        for i in range(4, num+1):
            dp_arr[i] = dp_arr[i-1] + dp_arr[i-2] + dp_arr[i-3]

    return dp_arr[num]
            
for _ in range(test_case):
    n = int(input())
    
    print(dp(n))    
    

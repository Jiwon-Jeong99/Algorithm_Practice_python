'''
boj)1463.py 1로 만들기
1. 2나 3으로 나누어 떨어지지 않는 것은 전 수+1을 해주면 된다.(1을 빼면 되니까)
2. 2나 3으로 나누어 떨어지는 것은 기존 규칙과 2나 3으로 나누었을 때를 비교해 최솟값을 선택하면 된다.
'''
import sys

input = sys.stdin.readline

n = int(input())

dp = [0] * (n+1)

for i in range(2, n+1):
    dp[i] = dp[i-1] + 1

    if i % 2 == 0:
        dp[i] = min(dp[i], dp[i//2]+1)
    if i % 3 == 0:
        dp[i] = min(dp[i], dp[i//3] + 1)

print(dp[n])

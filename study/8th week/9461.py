# 이 규칙을 어케 알아내냐!!
# 한 템포만 더 가볼걸
# p(n) = p(n-3) + p(n-2)
import sys
input = sys.stdin.readline

P = [0 for _ in range(101)]
P[1] = 1
P[2] = 1
P[3] = 1
for i in range(4, 101):
    P[i] = P[i-3] + P[i-2]

T = int(input())
for i in range(T):
    N = int(input())
    print(P(N))
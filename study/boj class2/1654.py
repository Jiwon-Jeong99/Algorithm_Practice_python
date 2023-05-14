# # 시간초과 방법
# import sys

# input = sys.stdin.readline
# k, n = map(int, input().split())

# len_arr = []
# for _ in range(k):
#     len = int(input())
#     len_arr.append(len)

# len_sum = sum(len_arr)
# max_len = len_sum // k

# while True:
#     cnt = 0
#     for i in len_arr:
#         cnt += i // max_len
        
#     if cnt < n:
#         max_len -= 1
#         continue
#     elif cnt >= n:
#         break

# print(max_len)

# 이분탐색
import sys
K, N = map(int, input().split())
lan = [int(sys.stdin.readline()) for _ in range(K)]
start, end = 1, max(lan) #이분탐색 처음과 끝위치

while start <= end: #적절한 랜선의 길이를 찾는 알고리즘
    mid = (start + end) // 2 #중간 위치
    lines = 0 #랜선 수
    for i in lan:
        lines += i // mid #분할 된 랜선 수
        
    if lines >= N: #랜선의 개수가 분기점
        start = mid + 1
    else:
        end = mid - 1
print(end)

# import sys

# k, n = map(int, sys.stdin.readline().split())
# arr = []

# for i in range(k):
#     arr.append(int(input()))

# start = 1
# end = max(arr)

# while (start <= end):
#     mid = (start + end) // 2
#     cnt = 0
#     for i in range(k):
#         cnt += arr[i] // mid
#     if cnt >= n:
#         start = mid + 1
#     else:
#         end = mid - 1
# print(end)

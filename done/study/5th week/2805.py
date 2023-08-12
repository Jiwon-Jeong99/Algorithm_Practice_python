import sys
input = sys.stdin.readline

n,m = map(int, input().rstrip().split())
trees = list(map(int, input().rstrip().split()))

# 이진탐색
start, end = 1, max(trees)
while start <= end:
    mid = (start+end) // 2
    total = 0 #벌목한 나무합
    for i in trees:
        if i > mid:
            total += i - mid
    
    # 벌목 높이 이분탐색
    if total == m:
        break
    elif total > m:
        start = mid + 1  
    else:
        end = mid - 1
print(mid)

# 질문 : 만약 total 값이 나왔을 때 그냥 mid 값을 프린트하면 되지 않나?
# 왜 start와 end값이 같을 때까지 진행해야하지?
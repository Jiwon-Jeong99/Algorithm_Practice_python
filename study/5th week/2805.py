import sys
input = sys.stdin.readline

n,m = map(int, input().rstrip().split())
trees = list(map(int, input().rstrip().split()))

# 이진탐색
start, end = 0, max(trees)
while start <= end:
    mid = (start+end) // 2
    total = 0 #벌목한 나무합
    for i in trees:
        if i > mid:
            total += i - mid
    
    # 벌목 높이 이분탐색
    if total >= m:
        start = mid + 1        
    else:
        end = mid - 1
print(end)
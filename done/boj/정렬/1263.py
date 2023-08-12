import sys

# 입력/ T,S는 이차원 배열 형태로 저장
# s: 마감 시간 / t: 걸리는 시간
n = int(sys.stdin.readline())
arr = []
for _ in range(n):
    t,s = map(int, sys.stdin.readline().split())
    arr.append((s,t))

# S: 마감시간 기준으로 오름차순으로 정렬
arr.sort(key=lambda x:x[0])

# 걸리는 시간의 총합
sumT = 0
for i in range(n):
    sumT += arr[i][1]

arrCut = arr[1:]
min = min(r[1] for r in arrCut)

# 24시 안에 끝낼 수 있는 일일 경우
if sumT <= 24:
    if sumT - arr[0][1] > 24 - arr[0][0]:
        answer = arr[0][0] - arr[0][1] - min
        print(answer)
    else:
        print(arr[0][0] - arr[0][1])
else:
    print("-1")
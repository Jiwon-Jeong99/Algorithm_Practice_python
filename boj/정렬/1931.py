import sys

list = []

n = int(sys.stdin.readline())
for _ in range(n):
    a,b = list(map(int,sys.stdin.readline().split()))
    list.append([a,b])

# 회의를 최대로 잡으려면 회의시간이 짧은 걸 공략
list.sort(key=lambda x:(x[1],x[0]))

end = list[0][1]
cnt = 0

for i in range(1,n):
    if list[i][0] >= end:
        cnt += 1
        end = list[i][1]

print(cnt)

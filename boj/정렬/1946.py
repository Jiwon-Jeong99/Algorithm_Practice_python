import sys

t = int(sys.stdin.readline())
for _ in range(t):
    arr = []
    n = int(sys.stdin.readline())
    for _ in range(n):
        a,b = list(map(int, sys.stdin.readline().split()))
        arr.append([a,b])
    
    # 서류 성적으로 오름차순 정렬
    arr.sort(key = lambda x:x[0])

    num = 0
    meet = float('inf')
    for i in arr:
        if i[1] < meet:
            num += 1
            meet = i[1]
    print(num)


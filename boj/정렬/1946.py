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
    # 할 수 있는 최대값 - 파이썬
    meet = float('inf')
    # 서류1등의 면접 점수랑 비교 + (6,1)(7,3)일 경우 서류7등 탈락시키기
    for i in arr:
        if i[1] < meet:
            num += 1
            meet = i[1]
    print(num)


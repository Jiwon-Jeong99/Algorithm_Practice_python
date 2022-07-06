import sys

t = int(sys.stdin.readline())
for _ in range(t):
    n = int(sys.stdin.readline())
    l = list(map(int, sys.stdin.readline().split()))

# 절대값 함수 : abs() - 파이썬 내장 함수
# 가장 작은 수부터 양쪽 끝에 배치해서 점점 안으로 큰 수 배치

# 오름차순 정렬
# range(시작,끝,간격)
    l.sort()
    arr = []
    tmp = []

    for i in range(0,n,2):
        arr.append(l[i])
    
    for j in range(1,n,2):
        tmp.append(l[j])
    
    # 파이썬의 리스트는 기본적으로 스택 형태
    # stack의 원소가 다 없어질 때까지 pop() 실행
    # while stack이름:
        # stack이름.pop()
    
    while tmp:
        # pop()은 리스트의 오른쪽 요소를 반환
        arr.append(tmp.pop())
    
    max_val = 0
    for z in range(n-1):
        max_val = max(max_val, abs(arr[z]-arr[z+1]))

    print(max_val)
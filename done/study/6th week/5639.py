import sys
# sys.setrecursionlimit(10 ** 9) # 재귀 허용 깊이를 수동으로 늘려주는 코드

def dfs(start, end):

    # 시작과 끝 값이 역전시 리턴
    if start > end:
        return

    temp = end + 1

    # 서브 트리 찾기
    for i in range(start + 1, end + 1):
        # 루트 보다 크면 오른쪽 서브 트리
        if graph[start] < graph[i]:
            temp = i
            break

    dfs(start + 1, temp - 1) # 왼쪽 서브 트리 재귀적으로 탐색
    dfs(temp, end) # 오른쪽 서브 트리 재귀적으로 탐색

    print(graph[start])


# 입력이 없을때까지 반복하여 입력을 리스트에 추가한다.
graph = []
while True:

    try:
        graph.append(int(sys.stdin.readline()))

    except:
        break

dfs(0, len(graph) - 1)
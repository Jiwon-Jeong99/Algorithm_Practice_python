def solution(n):
    answer = []
    triangle = [[0]*n for _ in range(n)]
    # 처음엔 무조건 아래로 향하게 x = -1
    x,y = -1,0
    num = 1
    
    for i in range(n):
        for j in range(i,n):
            
            # 아래
            if i % 3 == 0:
                x += 1
            # 오른쪽
            elif i % 3 == 1:
                y += 1
            # 위쪽 대각선
            elif i % 3 == 2:
                x -= 1
                y -= 1
            triangle[x][y] = num
            num += 1
    for i in triangle:
        for j in i:
            if j:
                answer.append(j)
    return answer
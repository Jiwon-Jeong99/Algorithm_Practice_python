n = int(input())
#시작 포인트
x, y = 1,1
#움직임 입력
plans = input().split()

#L,R,U,D에 따른 이동방향
#x=0, y=1 방향으로 움직이면, down
#x=-1, y=0 방향으로 움직이면, left
dx = [0,0,-1,1]
dy = [-1,1,0,0]
move_types = ['L','R','U','D']

#이동계획 하나씩 확인
for plan in plans:
    #이동후 좌표 구하기
    for i in range(len(move_types)):
        if plan == move_types[i]:
            nx = x + dx[i]
            ny = y + dy[i]
    
    #공간을 벗어나는 경우 무시
    if nx < 1 or ny < 1 or nx > n or ny > n:
        continue
    #이동 수행
    x, y = nx, ny
    
print(x,y)
            

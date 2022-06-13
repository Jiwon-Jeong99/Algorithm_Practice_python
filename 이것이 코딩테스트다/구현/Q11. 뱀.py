import sys

n = int(sys.stdin.readline())
k = int(sys.stdin.readline())
turn = []
map = [[0] * (n+1) for i in range(n+1)]

#맵의 정보
for i in range(k):
    a,b = map(int, sys.stdin.readline().split())
    map[a][b] = 1

#방향 회전 정보
z = int(sys.stdin.readline())
for i in range(z):
    x,c = sys.stdin.readline().split()
    turn.append(int(x),c)

dx = [0,1,0,-1]
dy = [1,0,-1,0]

def turn_info(way,c):
    if c == "L":
        way = (way - 1) % 4
    else:
        way = (way + 1) % 4
    return way

def simulate():
    x,y = 1,1
    map[x][y] = 2
    way = 0
    time = 0
    index = 0
    q = [(x,y)]
    while True : 
        nx = x + dx[way]
        ny = y + dy[way]

        if 1 <= nx and nx <= n and 1 <= ny and ny <= n and map[nx][ny] != 2:
            #사과 없는 경우
            if map[nx][ny] == 0:
                data[nx][ny] = 2
                q.append((nx,ny))
                px,py = q.pop(0)
                map[px][py] = 0
            #사과가 있는 경우
            if map[nx][ny] == 1:
                map[nx][ny] = 2
                q.append((nx,ny))
        #벽에 부딪히면
        else:
            time += 1
            break
            
        x,y = nx,ny
        time += 1
        if index < 1 and time == turn[index][0]:
            way = turn_info(way,turn[index][1])
            index += 1
    return time

print(simulate())

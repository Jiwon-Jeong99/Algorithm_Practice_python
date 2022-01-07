'''
(x,y)일때 x,y 가 0이 되는건 무시
R : y+1 
L : y-1
U : x+1
D : x-1

함수 move를 만들어
그냥 (1,1)에서 리스트가 말하는대로 for문 써서 가는 함수
(x,y)리턴

if 1보다 작으면 1로 만들어버리고
if n보다 크면 n으로 만들어버려서
최종 좌표 리턴
'''
#1 강사님 풀이 튜풀이용, 
#n = int(input())
#data_root = input().split()
n, data_root = 5, ["R","R","R","U","D","D","R","R","D","D"]
print(n,data_root)
x,y = 1,1

def move_dir(d_root): #위치 R > 이동좌표 (0,1)
    #튜플
  if d_root == "L":
    x_d,y_d = 0,-1
  elif d_root == "R":
    x_d,y_d = 0,1
  elif d_root == "U":
    x_d,y_d = -1,0
  elif d_root == "D":
    x_d,y_d = 1,0
  else:
    x_d,y_d = 0,0

  return x_d,y_d

for i in data_root:   #move_dir(i) = (0,0)
  if x+move_dir(i)[0] <= 0 or x+move_dir(i)[0] > n or y+move_dir(i)[1] <= 0 or y+move_dir(i)[1] > n :
    continue
  else:
    x = x + move_dir(i)[0]
    y = y + move_dir(i)[1]

print(x,y)


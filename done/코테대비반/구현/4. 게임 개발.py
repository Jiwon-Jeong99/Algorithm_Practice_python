'''
조건 :
입력 : 전체좌표
1. 가본 곳인가?
왼쪽에 안 가본 곳이 있으면
왼쪽으로 회전 후, 한 칸 전진 (이동o, 방향o)
왼쪽에 안 가본 곳이 없다면
왼쪽으로 회전 (이동x, 방향o)
2. 숫자 -> 방향(0->북)
3. 현재기준의 사방의 좌표 값

(반복) 4방향 중에 한 곳이라도 방문한 곳이 없다면
(조건) 4방향 모두 가본 곳이라면?
 - 뒤가 육지면 : 뒤로 가라
 - 뒤가 바다면 : 프로그램 종료
 else : 어느 한 곳은 안 간 곳
(조건)
왼쪽에 안 가본 곳이 있으면,
왼쪽으로 회전 후, 한 칸 전진 (이동o, 방향o)
왼쪽에 안 가본 곳이 없다면,
왼쪽으로 회전 (이동x, 방향o)
'''
#import sys
#n,m = map(int,input().split())
#a,b,di = map(int,input().split())
#l_map = list(sys.stdin.read().splitlines())

n,m,a,b,di = 4,4,1,1,0
l_map = ['1 1 1 1', '1 0 0 1', '1 1 0 1', '1 1 1 1']

list_map = [] #전체지도/좌표
list_map_value = []
visit_map = [(a,b)] #방문했던 곳 list
count = 1 #방문한 곳 수

for i in range(len(l_map)): #전체 지도 list_map 만들기
  for j in l_map[i]:
    if j != " ":
      list_map_value.append(int(j))
    
  list_map.append(list_map_value)
  list_map_value = []

print("list_map :",list_map)
print("list_map[a][b] :",list_map[0][1])

def dir_gps(a,b,di):#사방 위치 좌표값 (서,북,동,남)
  if di == 0:#방향이 북일 경우 사방 위치 좌표
    result = [(a,b-1,3),(a-1,b,0),(a,b+1,1),(a+1,b,2)]
  elif di == 1:
    result = [(a-1,b,0),(a,b+1,1),(a+1,b,2),(a,b-1,3)]
  elif di == 2:
    result = [(a,b+1,1),(a+1,b,2),(a,b-1,3),(a-1,b,0)]
  elif di == 3:
    result = [(a+1,b,2),(a,b-1,3),(a-1,b,0),(a,b+1,1)]
  return result

print("a,b,di : ",a,b,di)
print("위치 :dir_gps(a,b,di) : ",dir_gps(a,b,di))

def visit_chk(a,b): #True 방문했던 곳, False 안왔던 곳 / 바다라면 True
  v_chk = False
  global visit_map
  print ("visit_map :", visit_map)
  for i in range(len(visit_map)):
    print("visit_map[i][0] : ",visit_map[i][0])
    print("visit_map[i][1] : ",visit_map[i][1])
    if (visit_map[i][0] == a and visit_map[i][1] == b) or list_map[a][b] == 1:
      v_chk = True
      break
  
  return v_chk
def all_chk(a,b,di): #사방을 
    while all_chk(a,b,di) <= 4: 
  print("all_chk(a,b,di) : ",all_chk(a,b,di))
  print("dir_gps(a,b,di) :", dir_gps(a,b,di))

  if all_chk(a,b,di) == 4 and visit_chk(dir_gps(a,b,di)[3][0],dir_gps(a,b,di)[3][1]) == True: #모든방향 = 방문, 뒷쪽이 바다라면 = 프로그램 종료
    break
  elif all_chk(a,b,di) == 4 and visit_chk(dir_gps(a,b,di)[3][0],dir_gps(a,b,di)[3][1]) == False: #모든방향 = 방문, 뒷쪽이 육지라면 = 뒤로가기
    a = dir_gps(a,b,di)[3][0] # a좌표 이동
    b = dir_gps(a,b,di)[3][1] # b좌표 이동
    count += 1
    visit_map.append((a,b))
    print("visit_map : ", visit_map)
    
  elif visit_chk(dir_gps(a,b,di)[0][0],dir_gps(a,b,di)[0][1]) == False: #좌측이 방문 안 했던 곳 = 회전,이동
    a = dir_gps(a,b,di)[0][0] # a좌표 이동
    b = dir_gps(a,b,di)[0][1] # b좌표 이동
    di = dir_gps(a,b,di)[0][2] # 방향 이동
    count += 1
    visit_map.append((a,b))
    print("visit_map : ", visit_map)
  else: #왼쪽이 가 본 곳 = 회전
    di = dir_gps(a,b,di)[0][2] # 방향 이동

print("최종 count : ",count)




"""
1. 센서 좌표 정렬(위치)
2. 센서 간 거리가 가장 큰 값을 없애고
3. 남은 수신 가능 영역 거리 합
    집중국 1  |  집중국 2
센서 간 거리가 가장 긴 곳을 기준으로 잘라서 집중국 세우기
집중국이 관리하는 센서의 센서 간 거리 합이 수신가능영역 거리 합
"""

#센서 개수 n 6
#집중국 수 k 2   (k-1) 분리 기준 -> 가장 큰 수부터 몇개를 삭제
#센서의 좌표 1 6 9 3 6 7
#1. 센서 좌표 정렬(위치)
#2. 센서거리가 가장 큰 값을 없에고
#3. 남은 수신가능영역 거리 합

#n = input()
#k = input()
#g = list(map(int,input().split()))

n,k,g = 6,3,[1,6,9,3,6,7]
d_list = []
print(n,k,g)

g.sort()
print(g)
for i in range(len(g)-1):
  print(g[i])
  dist = g[i+1] - g[i]
  print("dist[",i+1,"]:",g[i+1],"-[",i,"]",g[i],"=",dist)
  print("dist:",dist)
  d_list.append(dist)

print("d_list :",d_list)
d_list.sort()
print("d_list :",d_list)
for i in range(k-1):
  d_list.pop()
print("d_list :",d_list)
print("sum(d_list) :",sum(d_list))

n, m = map(int, input().split())
result = [] #각줄 가장 작은 값을 넣는 list

for i in range(n): #행별로 줄을 가져오기 위한 반복 
    data = list(map(int, input().split())) #각 행 값
    min_value = min(data) #행의 최소값
    result.append(min_value) #최소값을 result list 추가

print(max(result)) #그중 가장 큰 값






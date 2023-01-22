array = [7,5,9,0,3,1,6,2,4,8]

for i in range(len(array)): #전체 리스트
    min_index = i #min_a 비교 기준 위치 값  
    for j in range(i+1,len(array)):
        if array[min_index]>array[j]:
            min_index=j
    array[i],array[min_index] = array[min_index],array[i]
print(array)
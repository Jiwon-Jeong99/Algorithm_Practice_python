n=int(input())
array=[]
for i in range(n):
    array.append(int(input()))

array.sort()
array.reverse()

for i in array:
    print(i,end=' ') #end=는 한줄로 출력값이 나오게 해줌 ' '는 띄어쓰기 되게


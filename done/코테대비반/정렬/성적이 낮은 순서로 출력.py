n = int(input())

a={}
x,y=0,0

for i in range(n):
    data = input().split()
    a[int(y)] = x

b = sorted(a.values()) #값만 정렬 .items()일 경우 키, value 다 

for i in b:
    print(i,end=' ')
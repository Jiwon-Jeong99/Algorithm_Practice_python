import sys

n = int(sys.stdin.readline())
agree =[]
for i in range(n):
    age, name = sys.stdin.readline().split()
    agree.append([int(age),name])

# [age,name]에서 age만 비교
agree.sort(key = lambda x : x[0])

# [[a,b],[c,d]] 중 j는 [a,b]임 
for j in agree:
    print(j[0],j[1])
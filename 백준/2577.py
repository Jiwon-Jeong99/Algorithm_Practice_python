import sys

a = int(sys.stdin.readline())
b = int(sys.stdin.readline())
c = int(sys.stdin.readline())

answer = a*b*c
answer_list = list(map(int,str(answer)))

for i in range(10):
    result = answer_list.count(i)
    print(result)

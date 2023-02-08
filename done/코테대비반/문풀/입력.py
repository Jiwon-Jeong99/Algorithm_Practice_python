import sys

a = int(sys.stdin.readline())
b,c,d = map(int,sys.stdin.readline().split())
#int형으로 다 바꿔주니까 숫자일때만 사용할 것
list_x = list(map(int,sys.stdin.readline().split()))

print(a)
print(b,c,d)
print(list_x)

#문자열은 rstrip() 공백 삭제
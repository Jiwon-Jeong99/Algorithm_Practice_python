import sys

n = int(sys.stdin.readline())

#띄어쓰기 하지 않은 숫자 각각의 합
print(sum(map(int,sys.stdin.readline().rstrip())))
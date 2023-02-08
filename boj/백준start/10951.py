import sys

# 예외처리
while True:
    try:
        a,b = map(int,sys.stdin.readline().split())
    except:
        break
    print(a+b)
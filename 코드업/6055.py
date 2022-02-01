import sys

a,b = map(int, sys.stdin.readline().split())

if a == 1 or b == 1:
    print('True')
else:
    print('False')
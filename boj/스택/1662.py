import sys

s = list(sys.stdin.readline().rstrip())

cnt = 0
length = 0

while s:
    if s[-1] == ')':
        s.pop()
    elif s[-1].isdigit():
        length += 1
        s.pop()
    






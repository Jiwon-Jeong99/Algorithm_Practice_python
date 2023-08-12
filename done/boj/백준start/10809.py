import sys

s = sys.stdin.readline().rstrip()

#아스키코드 숫자 범위
alphabat = list(range(97,123))

for i in alphabat:
    print(s.find(chr(i)))
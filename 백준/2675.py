import sys

t = int(sys.stdin.readline())

for j in range(t):
    r, s = sys.stdin.readline().split()
    # text는 문자열이라는 것을 명시하고
    text = ''
    for i in s:
        text += int(r) * i
    print(text)

import sys

left = []

for i in range(10):
    n = int(sys.stdin.readline())
    left.append(n%42)

left_set = set(left)
print(len(left_set))



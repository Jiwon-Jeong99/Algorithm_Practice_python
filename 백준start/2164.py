import sys

n = int(sys.stdin.readline())

n_list = []
for i in range(n):
    n_list.append(i+1)

while len(n_list) > 1:
    n_list.pop(0)
    n_list.append(n_list[0])
    n_list.pop(0)
    if len(n_list) == 1:
        print(n_list[0])
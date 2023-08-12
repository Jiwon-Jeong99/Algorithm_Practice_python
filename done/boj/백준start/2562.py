import sys
num_list = []
for i in range(9):
    num_list.append(int(sys.stdin.readline()))

max_num = max(num_list)
print(max_num)
print(num_list.index(max_num) + 1)
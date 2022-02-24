import sys

n = int(sys.stdin.readline())
n_list = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
m_list = list(map(int, sys.stdin.readline().split()))

for i in m_list:
    for j in n_list:
        if i != j and n_list[-1] == i:
            print('0')
        elif i == j:
            print('1')
            break

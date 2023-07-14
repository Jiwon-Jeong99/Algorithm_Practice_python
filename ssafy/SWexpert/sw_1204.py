"""

"""
from collections import Counter

test_case = int(input())

for i in range(test_case):
    test_num = int(input())
    scores = list(map(int, input().split()))

    mode = Counter(scores).most_common()

    max_mode = []
    max_mode.append(mode[0][0])
    for j in range(len(mode)-1):
        if mode[j][1] == mode[j+1][1]:
            max_mode.append(mode[j+1][0])
        else:
            break

    ans = max(max_mode)

    print("#%d" % (test_num), ans)

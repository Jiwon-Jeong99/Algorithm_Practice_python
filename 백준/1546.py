import sys

n = int(sys.stdin.readline())
score_list = list(map(int,sys.stdin.readline().split()))

max_num = max(score_list)

result = 0
for j in score_list:
    result += j / max_num * 100

print(result/n)
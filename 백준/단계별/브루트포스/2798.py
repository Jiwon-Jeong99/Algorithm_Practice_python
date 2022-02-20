import sys
from itertools import combinations

# 입력
n,m = map(int, sys.stdin.readline().split())
num_list = list(map(int, sys.stdin.readline().split()))

biggest = 0

# 조합
for cards in combinations(num_list,3):
    card_sum = sum(cards)
    if biggest < card_sum <= m:
        biggest = card_sum
print(biggest)
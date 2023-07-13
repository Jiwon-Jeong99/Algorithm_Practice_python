"""
DP - knapsack
"""
item_count, weight_limit = map(int, input().split())
# 아래 for문을 1부터 돌리기 위해 추가한 것
bag = [[0, 0]]

# +1한 이유는 for문 시작을 1로 하려고
knapsack = [[0 for _ in range(weight_limit + 1)] for _ in range(item_count + 1)]

for _ in range(item_count):
    bag.append(list(map(int, input().split())))

# DP-knapsack
for i in range(1, item_count + 1):
    for j in range(1, weight_limit + 1):
        weight = bag[i][0]
        value = bag[i][1]

        if j < weight:
            # weight보다 작으면 위의 값을 그대로 가져온다
            knapsack[i][j] = knapsack[i-1][j]
        else:
            knapsack[i][j] = max(value + knapsack[i - 1][j - weight], knapsack[i - 1][j])

print(knapsack[item_count][weight_limit])

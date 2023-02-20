import sys
input = sys.stdin.readline

n,m = map(int, input().split())

cost = []
min_cost = []

for _ in range(m):
    a,b = map(int, input().split())
    cost.append(a)
    cost.append(b)

print(cost)
    
for i in range(0,len(cost)-1,2):
    min_cost.append(min(cost[i],cost[i+1]*n))
    print(min_cost)

print(min(min_cost))
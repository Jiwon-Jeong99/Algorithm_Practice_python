import sys

n = int(sys.stdin.readline())

num_list = []
count_list = []
for i in range(n):
    num_list.append(int(sys.stdin.readline()))

num_set = set(num_list)
sorted(num_set)
for j in num_set:
    count_list.append(num_list.count(j))
    
a = round(sum(num_list) / n)
b = num_list[(n-1)/2]
c = count_list[1]
d = max(num_list) - min(num_list)

print(a)
print(b)
print(c)
print(d)
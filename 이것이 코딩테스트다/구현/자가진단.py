arr = [1,4,4,5,5,5,6]

my_set = set(arr)
sorted(my_set)

new = []
for i in my_set:
    num = arr.count(i)
    if num > 1 :
        new.append(num)

if len(new) > 0 :
    print(new)
else:
    print([-1])
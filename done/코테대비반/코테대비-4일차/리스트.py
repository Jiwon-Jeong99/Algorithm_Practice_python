a = [1, 2, "Life", "is"]

b = [1, 2, ["Life", "is"]]
#0 1    2
#  0     1

print(b[2][1])

c = [1, 2, 3, ['a', 'b', 'c'], 4, 5]
print(c[2:5])
print(c[3][:2])

d = [1, 2, 3]
print(d*3)
print(str(d[2])+"hi")
d.append(4)
print(d)
d.sort()
print(d)
d.index(3)
print(d)

a = input()

num = 0
for i in range(n-1):
  num += a[i]
z = num / n
print(z)

while i < len(a):
  if 91 <= a[i] <= 100:
    result = 5
  elif 81 <= a[i] <= 90:
    result = 4
  elif 71 <= a[i] <= 80:
    result = 3
  elif 61 <= a[i] <= 70:
    result = 2
  elif 0 <= a[i] <= 60:
    result = 1
print(result)

score = 0
while i < len(a):
  if 71 <= a[i] <= 100:
    score += a[i]
c = score / i


a.sort()
v = a[-1]
b = a[0]

while i < len(a):
  if result >= 3:
    a.sort()

print(z, x, c, v, b, n, m)

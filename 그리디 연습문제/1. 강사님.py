a = int(input())
count = 0
coin_types = [500, 100, 50, 10]

for coin in coin_types:
  n = a // coin
  count = count + n
  a = a % coin

print(count)

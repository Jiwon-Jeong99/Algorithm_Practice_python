#값을 여러개 input 받을 때 split() 해주기
n, m, k = map(int, input().split())
data = list(map(int, input().split()))


def large(n, m, k, data):
  data.sort()
  sum = 0

  if data[-1] == data[-2]:
    sum = data[-1] * m

  else:
    L = m % (k+1)
    Q = m // (k+1)

    sum = (data[-1] * k + data[-2]) * Q + data[-1] * L

  return sum


print(large(n, m, k, data))

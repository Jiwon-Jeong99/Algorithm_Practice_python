#더하거나 0 1 +
#곱하거나 2 9 x

import sys
n = sys.stdin.readline()
result = 0

for i in range(int(len(n))-1):

  if i == 0:
    result = int(n[i])
    continue

  if int(n[i]) == 0 or int(n[i]) == 1 or result == 0:
    result += int(n[i])
  else:
    result *= int(n[i])

print(result)
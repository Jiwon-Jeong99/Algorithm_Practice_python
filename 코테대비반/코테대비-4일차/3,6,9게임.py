n = int(input("0~100사이 정수를 입력하세요 : "))

list = []
a = 0
while a < n:
  a += 1
  if a % 3 == 0 and a % 10 == 0:
    list.append('박수,으악')
  elif a % 3 == 0:
    list.append('박수')
  elif a % 10 == 0:
    list.append('으악')
  else:
    list.append(a)
print(list)

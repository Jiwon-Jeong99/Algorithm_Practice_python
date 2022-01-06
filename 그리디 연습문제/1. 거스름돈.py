'''
500원 나눠서 //몫 저장
나머지 100원으로 다시 나눔
마지막에 몫
'''
a = int(input())

def charge(a):
  b = a // 500
  b_left = a % 500

  c = b_left // 100
  c_left = b_left % 100

  d = c_left // 50
  d_left = c_left % 50

  e = d_left // 10
  
  return (b+c+d+e)

print(charge(a))
import random  # 랜덤함수

x = random.randrange(1, 100)
answer = 0
while True:
  num = int(input("값을 입력하세요 : "))
  answer += 1
  if num > 99:
    print("0~99 정수를 적어주세요")
  elif num > x:
    print("다운")
  elif num < x:
    print("업")
  elif num == x:
    print('{answer}번 만에 맞췄습니다.'.format(answer), "랜덤값 : ", x)
    break

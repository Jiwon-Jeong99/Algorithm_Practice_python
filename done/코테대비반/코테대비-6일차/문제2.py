import random

p = '''
가위바위보를 시작합니다.
숫자로 당신의 선택을 입력하세요.
가위 : 1
바위 : 2
보 : 3
당신은 무엇을 내겠습니까?
'''

user = input(p)
com = random.randint(1, 3)


def game(user, com):
  if user == com:
    result = "무"

  elif user == 1:
    if com == 2:
      result = "패"
    elif com == 3:
      result = "승"

  elif user == 2:
    if com == 1:
      result = "승"
    else:
      result = "패"

  elif user == 3:
    if com == 1:
      result = "패"
    else:
      result = "승"
  return result


def name(x):
  if x == 1:
    result = "가위"
  elif x == 2:
    result = "바위"
  elif x == 3:
    result = "보"
  return result


for i in range(10):
  print("컴퓨터{0} : {1}당신 = {2}".format(name(com), name(user), game(user, com)))
  print("%d전 %d승 %d무 %d패 " % (i,))

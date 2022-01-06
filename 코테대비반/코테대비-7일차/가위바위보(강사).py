import random

pp = "▶️가위1,바위2,보3:"


def hand(yours):
  #입력(숫자) - 출력(가위/바위/보)
  if int(yours) == 1:
    result = "가위"
  elif int(yours) == 2:
    result = "바위"
  elif int(yours) == 3:
    result = "보"
  else:
    result = "바보"
  return result


def game(you):
  #you낸거 comp낸거 비교
  a = []
  comp = random.choice(["가위", "바위", "보"])
  print("you =", you, "vs", comp, "=comp")

  if you == comp:
    #무승부
    a = [0, 1, 0]
  else:
    if you == "가위" and comp == "바위":
      a = [0, 0, 1]
    elif you == "가위" and comp == "보":
      a = [1, 0, 0]
    elif you == "바위" and comp == "가위":
      a = [1, 0, 0]
    elif you == "바위" and comp == "보":
      a = [0, 0, 1]
    elif you == "보" and comp == "가위":
      a = [0, 0, 1]
    elif you == "보" and comp == "바위":
      a = [1, 0, 0]
  return a, comp


win = 0  # 승
draw = 0  # 무
lose = 0  # 패
count = 0  # 전
q = ""

while count < 10:
  yours = input(pp)  # you 입력값 받기
  you_hand = hand(yours)  # you 가위/바위/보
  if you_hand == "바보":
    print("이딴거 내지마")
    continue
  a, comp_hand = game(you_hand)  # 컴대결 > 값반환
  #a = [0:승,1:무,2:패]
  win += a[0]
  draw += a[1]
  lose += a[2]
  count += 1  # 전 추가

  if a[0] == 1:
    q = "승"
  elif a[1] == 1:
    q = "무"
  else:
    q = "패"

  print(f"컴퓨터({comp_hand}) : ({you_hand})당신 = {q}")
  print(f"{count}전 {win}승 {draw}무 {lose}패")

print("승률:", (win/10)*100, "%")

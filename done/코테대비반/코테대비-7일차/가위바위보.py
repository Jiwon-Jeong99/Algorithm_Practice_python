'''
슈도코드/의사코드

함수) 입력(숫자) - 출력(가위/바위/보)
함수) 승/무/패 판단

반복문) 
  10회 경기
  입력 프롬프트
  입력 : 0<n<4
  함수>출력
  함수>승/무/패 판단
  승/무/패 저장
  출력>1전 1승 0무 0패

출력>승률
'''
#반복문이 중첩이 될수록 연산속도가 느려짐
import random

p = '''
가위바위보를 시작합니다.
숫자로 당신의 선택을 입력하세요.
가위 : 1
바위 : 2
보 : 3
당신은 무엇을 내겠습니까?
'''

#함수) 입력(숫자) - 출력(가위/바위/보)


def hand(yours):
  if yours == 1:
    result = "가위"
  elif yours == 2:
    result = "바위"
  elif yours == 3:
    result = "보"
  else:
    result = "바보"
  return result


def game(you):
  #you낸거 com낸거 비교
  a = []
  com = random.choice(["가위", "바위", "보"])
  print("you=", you, "vs", com, "=com")

  if you == com:
    #무승부
    a = [0, 1, 0]
  else:
    if you == "가위" and com == "바위":
      a = [0, 1, 0]
    elif you == "가위" and com == "보":
      a = [1, 0, 0]
    elif you == "바위" and com == "가위":
      a = [1, 0, 0]
    elif you == "바위" and com == "보":
       a = [0, 0, 1]
    elif you == "보" and com == "가위":
        a = [0, 0, 1]
    elif you == "보" and com == "바위":
      a = [1, 0, 0]
  return a, com


win = 0  # 승
draw = 0  # 무
lose = 0  # 패

count = 0
qq = ""


while count < 10:
  yours = input(p)  # you 입력값 받기
  you_hand = hand(yours)  # you 가위/바위/보
  a, com_hand = game(you_hand)  # 컴대결 > 값반환
  #a = [0:승,1:무,2:패]
  win += a[0]
  draw += a[1]
  lose += a[2]
  count += 1

  if a[0] == 1:
    qq = "승"
  elif a[1] == 1:
    qq = "무"
  else:
    qq = "패"

  print(f"컴퓨터({com_hand}) : ({you_hand})당신 = {qq}")
  print(f"{count}전 {win}승 {draw}무 {lose}패")

print("승률 : ", (win/10)*100, "%")

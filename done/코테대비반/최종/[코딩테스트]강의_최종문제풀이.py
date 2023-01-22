
■■■■ ▶ 제목 : 단어만들기 게임
#문제 : 주어지는 2개의 문자카드 묶음으로 특정 단어를 만들면 되는 게임이다.
첫 줄에는 각 문자 카드 묶음에서 사용할 수 있는 문자의 개수 n을 정수형태로 보여준다.
두번째 줄에 "1번 문자 묶음"이 보여지며 첫 문자가 카드의 맨 위에 놓여져 있는 문자 카드이고 끝 문자가 맨 바닥에 놓인 문자 카드이다.
세번째 줄은 "2번 문자 묶음"이 동일한 형태로 놓여있다.
네번째 줄에 완성시켜야할 단어가 주어진다.

1번개의 문자 묶음을 확인하여 번갈아가면서 문자를 꺼내어 단어를 완성하면 되고 꺼내야할 문자가 없으면 다른 문자 묶음에서 꺼내어도 된다.
단, 문자카드는 각 묶음별로 n번 이하로 사용 가능하며 카드를 사용하지 않고 다음 묶음으로 넘어가면 사용하지 않은 것으로 판단된다.

두개의 문자 묶음으로 단어를 완성하고 아래의 조건에 맞춰 결과를 출력 하라.

출력은 첫줄에 단어의 완성 여부를 0 또는 1로 출력 하며 0은 완성, 1은 미완성을 나타낸다.
두번째 줄은 1번 카드묶음에 카드의 남은 숫자를 보여준다.
세번째 줄은 2번 카드묶음에 카드의 남은 숫자를 보여준다.
보여주는 형식은 아래의 출력 예시를 따른다.

[입력]
7
HPYTDYA
APBIRHA
HAPPYBIRTHDAY


[출력]
#1 0
#2 1
#3 0



[풀이]

import sys

a = int(sys.stdin.readline())
card1 = list(sys.stdin.readline().rstrip()) #PYTDYA
card2 = list(sys.stdin.readline().rstrip()) #APBIRHA
word = list(sys.stdin.readline().rstrip()) #HAPPYBIRTHDAY
new_word = []

for i in range(len(word)): #전체 단어 돌리면서 맞는 카드 가져오기
  #print(word[i])

  if word[i] == card1[0]: #단어의 위치별 문자와 1카드묶음을 비교
    new_word.append(card1[0]) #새로운 단어리스트에 삽입
    card1.pop(0) #기존 문자묶음에서 삭제
    continue

  if word[i] == card2[0]: #단어의 위치별 문자와 1카드묶음을 비교
    new_word.append(card2[0]) #새로운 단어리스트에 삽입
    card2.pop(0) #기존 문자묶음에서 삭제
    continue

#print("\n\n")
#print("card1 : ",card1)
#print("card1 : ",card2)
#print("new_word : ",new_word)
#print("new_word : ",new_word==word)

if new_word == word:
  print("#1",0)
else:
  print("#1",1)

print("#2",len(card1))
print("#3",len(card2))


[코드만]

import sys

a = int(sys.stdin.readline())
card1 = list(sys.stdin.readline().rstrip()) 
card2 = list(sys.stdin.readline().rstrip())
word = list(sys.stdin.readline().rstrip()) 
new_word = []

for i in range(len(word)): 

  if word[i] == card1[0]: 
    new_word.append(card1[0]) 
    card1.pop(0) 
    continue

  if word[i] == card2[0]: 
    new_word.append(card2[0]) 
    card2.pop(0) 
    continue

if new_word == word:
  print(0)
else:
  print(1)

print(len(card1))
print(len(card2))
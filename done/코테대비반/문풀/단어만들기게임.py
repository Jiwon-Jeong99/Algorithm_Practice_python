#맞는데도 에러가 난다 하면 주석을 싹 다 지워보기
import sys

n = int(sys.stdin.readline())
#rstrip()으로 \n 없애주기
card1 = list(sys.stdin.readline().rstrip())
card2 = list(sys.stdin.readline().rstrip())
word = list(sys.stdin.readline().rstrip())
new_word=[]

#전체 단어 돌리면서 맞는 카드 가져오기
for i in range(len(word)):
    #단어의 위치별 문자와 card1 묶음을 비교
    if word[i] == card1[0]:
        new_word.append(card1[0]) #새로운 단어리스트에 삽입
        card1.pop(0) #기존 문자묶음에서 삭제
        continue
    
    if word[i] == card2[0]:
        new_word.append(card2[0])
        card2.pop(0)
        continue

if new_word == word:
    print("#1",0)
else : 
    print("#1",1)

print("#2",len(card1))
print("#3",len(card2))





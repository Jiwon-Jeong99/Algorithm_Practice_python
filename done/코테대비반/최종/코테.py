'''
입력
1. 디자인-문자열
2. (1)번 공급라인 장식-문자열
3. (2)번 공급라인 일련번호-빈 칸 구분 숫자
출력
1. 완성된 팔찌개수-정수
2. (1)번 공급라인 남은 장식 수-정수
3. (2)번 공급라인 남은 일련번호 중 가장 작은 수-정수
4. (1)번 공급라인 폐기된 장식 수-정수

for mark in marks:
    mark

#3은 #1+1값을 출력

한번 텀이 끝나면 
'''
import sys

#입력
design = list(sys.stdin.readline().rstrip()) #팔찌 디자인
mark_1 = list(sys.stdin.readline().rstrip()) #1번 공급라인
mark_2 = list(map(int, sys.stdin.readline().split())) #2번 일련번호

left = 0 #남은 장식 수 
perfect = 0 #완성된 장식 수
trash = 0 #폐기된 장식 수 

new_item = []


for j in range(len(mark_2)):
    for i in range(len(design)):
        if design[i] == mark_1[0]:
            new_item.append(mark_1[0])
            mark_1.pop(0)
            continue

        if design[i] != mark_1[0]:
            while design[i] != mark_1[0]:
                mark_1.pop(0)
                trash += 1

                if design[i] == mark_1[0]:
                    new_item.append(mark_1[0])
                    mark_1.pop(0)
                    break
            continue
    
    if len(mark_1) == 0:
        break

#1 len(new_item) // len(design) = perfect
#2 
#3 perfect+1
#4 trash
perfect = len(new_item) // len(design) #완성된 팔찌개수
num = perfect + 1

print(f"#1 {perfect}")
print(f"#2 {left}")
print(f"#3 {num}")
print(f"#4 {trash}")

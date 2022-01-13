'''
다음과 같이 3줄에 각 입력 값이 나올 때
첫줄=나오는 데이터의 총 줄 수
2~4줄=데이터
2번줄은 데이터의 기준값(키값)이 된다
#2,3번을 1개의 딕셔너리로, 2,4번을 1개의 딕셔너리로
입력예시
3
1 2 3 4 5 6 
a b c d e f
가 나 다 라 마 바 사
출력예시
{1:'a', 2:}
{1:'가'}
'''
import sys

a = sys.stdin.readline()
list_all = []

for i in range(int(a)):
    list_all.append(sys.stdin.readline().split())

#print(list_all[0])#첫번째 리스트만 가져올 수 있음
for x in range(1,int(n)): #몇줄인가?줄별딕셔너리
    for y in range(len(list_all[0])):
        print("x:",x)
        list_dic[list_all[0][y]] = list_all[x][y]

    print(list_dic)



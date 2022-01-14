■■■■■■■■■■■■■■■■■■■■■■■■■■■■

▶ 값 입력 받기
import sys

a = int(sys.stdin.readline()) #단일값
b,c,d = map(int,sys.stdin.readline().split()) #정해진 수 만큼
e = list(map(int,sys.stdin.readline().split())) #배열로
word = list(sys.stdin.readline().rstrip()) #문자열 리스트로 입력 받기(우측 엔터키 삭제) AAA -> ['A','A',A']


▶ 값 출력

print("%s은 %s세\n%s은 %s세 이다." % (a,c,b,d))
print("{name1}은 {age1}세\n{name2}은 {age2}세 이다.".format(name1=a,age1=c,name2=b,age2=d))
print(f"{a}은 {c}세\n{b}은 {d}세 이다.")


■■■■■■■■■■■■■■■■■■■■■■■■■■■■

■ 자료형
b = int(a) #숫자, 정수
c = str(a) #문자열
print("%s %s %s %s" % (a,b,c,d))
print("9x1=%-10s*" % (a))
print("{0:+^10} {a:-<10} {b:=>10}".format(50,b="apple",a="50"))
print("{0:0.2f}".format(x)) #소수점표현(반올림)
print("{name} {age}".format(name=name,age=age))
print(f"{name} {age}")

a = " Ho bby "
b = "h,o,b,b,y"
print(a.count("b")) #문자 개수
print(a.find("b")) # 문자 위치
print(a.index("b")) # 문자 위치
print(",".join(a)) # 구분자 넣기
print(a.upper()) #대문자
print(a.lower()) #소문자
print(a.rstrip()) #우측 공백 지우기
print(a.lstrip()) #좌측 공백 지우기
print(a.strip()) #좌우 공백 지우기
print(a.replace("Ho ","To")) #문자열 바꾸기
print(b.split(","))

■■■■■■■■■■■■■■■■■■■■■■■■■■■■

▶ 리스트 자료형
a = [1,2,3,4,5]
인덱싱 a[0] = 1
슬라이싱 a[:2] = [1,2]
더하기 a+b 반복 a*3
길이 len(a)
자료형 int(a) str(a)
값 수정 a[2] = 4
값 삭제 del a[2]

뒤에 추가 a.append(값)
정렬 a.sort()
뒤집기 a.reverse()
위치반환 a.index(값)
위치삽입 a.insert(위치, 값)
제거 a.remove(값) - 처음나오는값
요소추출 a.pop() - 마지막값
요소추출 a.pop(위치)
값개수검색 a.count(값)
리스트확장/추가 a.extend(리스트)

print(a[0:10:2]) #처음,끝,간격 - 10까지만 홀수만 출력
print(a[::2]) # 전체 홀수만 출력하라
print(a[1::2]) #전체 짝수만 출력하라
print(a[-1:-100:-2]) # 짝수만 역순 출력하라
print(a[-2:-100:-2]) # 홀수만 역순 출력하라
print(a[::-1]) #리스트 전체 역순




■■■■■■■■■■■■■■■■■■■■■■■■■■■■

▶ 리스트 - 튜플

list_a = ["하나", "둘", "셋"]
tp_a = tuple(list_a) #리스트를 튜플로 입력
print("자료형 : ", type(tp_a)) # 자료형 확인
list_b = list(tp_a) #튜플을 리스트로 입력
a,b,c = list_b #list의 값을 순차적으로 변수에 입력
list_range = list(range(0,10)) #0부터 10미만까지 list에 입력
tp_range = tuple(range(1,100,2)) #1부터 100미만인 홀수를 튜플에 입력



■■■■■■■■■■■■■■■■■■■■■■■■■■■■

▶ 랜덤함수

import random

print(random.randint(1,10)) #범위 내의 숫자 랜덤
print(random.choice("happy")) #문자열 문자 랜덤
print(random.choice([13,5,7,9])) #리스트 랜덤


■■■■■■■■■■■■■■■■■■■■■■■■■■■■

▶ 딕셔너리
a = {1: "a"}
print(a)

#딕셔너리 key=변하지않는값, value=상관없음
#key로 검색을 하기 때문에 (위치개념 없다)
a["a"] = 10 #a라는 키 값으로 10을 추가
a["b"] = 20
a["name"] = "Kevin" #name키에 Kevin값을 추가
a["abc"] = ["a","b","c"] #abc키에 list 추가
a["def"] = ("d","e","f") #def키에 tuple 추가

a[(1,2,3)] = 6 #tuple키에 6을 추가
#a[[4,5,6]] = 6 #list는 key로 정의 할 수 없다.

print(f"a['def'] : {a['def']}")
print("a['def'] : {0}".format(a['def']))

del a["a"] # key:value 삭제
print("a.keys() : ", a.keys(), "\n")

for k in a.keys(): #key list 출력
  print(k) 

list_akeys = list(a.keys()) #리스트로 변환
print("list_akeys :", list_akeys, "\n")

a.clear() #딕셔너리 모두 삭제

print(a.get('b'),"키값이 없습니다.")



■■■■■■■■■■■■■■■■■■■■■■■■■■■■

▶ 집합자료형
s1 = set([1,2,3,4,5,6])
s2 = set([4,5,6,7,8,9])
print(s1 & s2, s1.intersection(s2)) #교집합
print(s1 | s2, s1.union(s2)) #합집합
print(s1 - s2, s1.difference(s2)) #차집합

s1.add(7) #한개 요소 추가
s1.remove("a") #제거
s1.update(["a","b","c"]) #여러개추가


■■■■■■■■■■■■■■■■■■■■■■■■■■■■

▶ 불 자료형

a = True
b = False
print( a ) #True
print( b ) #False
print( 1 == 1 ) #True
print( 2 > 1 ) #True
print( 2 < 1 ) #False
print(bool([1,2,3])) #True
print(bool()) #False


■■■■■■■■■■■■■■■■■■■■■■■■■■■■

▶ 함수

a,b,*c = 1,2,3,4,5,6,7,8
print(a)
print(b)
print(c)

def add_mul(choice, *args):
def add_mul(choice, args=[]):

def add_mul(choice, *args):
  ####### 수행
  return result

sum = add_mul("add",1,2,3,4,5)
print(sum)


def print_kwargs(**args): #딕셔너리
  print(args)

print_kwargs(a=1,b=2,w="t",asdwef="asdssd")

def gtest():
  global a #글로벌 변수로 변경
  a = a+1

def say_myself(name, old=30, man=True): / 매개변수 기본 값 지정



■■■■■■■■■■■■■■■■■■■■■■■■■■■■
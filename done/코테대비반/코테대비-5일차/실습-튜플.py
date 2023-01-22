#코테에서 값을 input 받는 방법
import sys
a = int(sys.stdin.readline())
print(a)

#3개의 정수를 input 받는 방법
b, c, d = map(int, sys.stdin.readline().split())
print(b, c, d)

#정해지지 않은 개수의 정수를 input 받는 방법
data = list(map(int, sys.stdin.readline().split()))
print(data, "\n")

#\n 을 없애면서 값을 받는 방법
#e = sys.sydin.readline().rstrip()
#\n을 없애면서 여러개의 값을 받는 방법
#f = sys.sydin.readline().rstrip().split()

#튜플
t1 = (1)
t2 = (1,)
t3 = (1, 2, 3)
t4 = 1, 2, 3
t5 = ('a', 'b', ('ab', 'cd'))
t6 = 1
t7 = 1,

print(t1)
print(t2)
print(t3)
print(t4)
print(t5)
print(t6)
print(t7, "\n")

#튜플에서는 sort()도 안됨 -> 수정하는거니까
#튜플 슬라이싱 가능
#튜플은 del이 안됨

#튜플 인덱싱
t10 = (1, 2, 'a', 'b')
t11 = (3, 4)
print(t10[0])
print(t10[1:])
print(t10 + t11)
print(len(t10), "\n")

list_a = [1, 2, 3]
list_b = (1, 2, 3,)
print("자료형 : ", type(list_a))
print("자료형 : ", type(list_b), "\n")

#자료형 변환
tp_a = tuple(list_a)
print(tp_a)
print("자료형 : ", type(tp_a), "\n")

tp_b = list(tp_a)
print(tp_b)
print("자료형 : ", type(tp_b), "\n")

#tp_b의 인덱스 출력
x, y, z = tp_b
print(x, y, z, "\n")

#0~9까지 출력
list_range = list(range(0, 10))
print(list_range)
print("자료형 : ", type(list_range), "\n")

#0~9까지 0에서 2씩 추가해라
tp_range = tuple(range(0, 10, 2))
print(tp_range)
print("자료형 : ", type(tp_range), "\n")

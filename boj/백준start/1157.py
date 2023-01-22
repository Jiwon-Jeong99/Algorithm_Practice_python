import sys

a = sys.stdin.readline().upper()

# 입력받은 문자열에서 중복값 제거
a_set = list(set(a))

answer = []
for i in a_set:
    b = a.count(i)
    answer.append(b)

# 최대값이 여러개라면
if answer.count(max(answer)) > 1:
    print('?')

else:
    index_num = answer.index(max(answer))
    print(a_set[index_num])


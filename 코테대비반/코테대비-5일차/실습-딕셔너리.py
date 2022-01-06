a = {1: 'a'}
a[2] = 'b'
print(a)

#딕셔너리 key=변하지 않는 값, value=상관없음
#key로 검색을 하기 때문에 변하는 값이면 안됨 (위치개념x)
#list는 키 값으로 정의x

#name키에 pay값을 추가
a['name'] = 'pay'
print(a)

a[3] = [1, 2, 3]
print(a)

a["oh"] = 3
print(a)

#키는 중복이 안됨
#같은 키 값이라면 나중에 써진걸로 값 업데이트
a["abc"] = ['a', 'b', 'c']  # abc키에 list 추가
a["abc"] = ['d', 'e', 'f']  # abc키에 tuple 추가
print(a)

a[(1, 2, 3)] = 6  # tuple키에 6추가
#a[[4,5,6]]=6 #list는 key로 정의할 수 없다.

a[4, ] = 6
print(a[4, ])
#print(a[4])하면 안나옴

b = {1: 'a'}
b["a"] = 10
b['def'] = ('d', 'e', 'f')


print('b: ', b, "\n")
print(f"b['a']:{b['a']}")
print(f"b['def']:{b['def']}")
print("b['def']:{0}".format(b['def']))

del b["a"]
print("b:", b, "\n")

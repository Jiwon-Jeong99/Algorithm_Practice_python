a = {1: "a"}
print(a)

#딕셔너리 key=변하지않는값, value=상관없음
#key로 검색을 하기 때문에 (위치개념 없다)
a["a"] = 10  # a라는 키 값으로 10을 추가
a["b"] = 20
a["name"] = "Kevin"  # name키에 Kevin값을 추가

a["abc"] = ["a", "b", "c"]  # abc키에 list 추가
a["def"] = ("d", "e", "f")  # def키에 tuple 추가

a[(1, 2, 3)] = 6  # tuple키에 6을 추가
#a[[4,5,6]] = 6 #list는 key로 정의 할 수 없다.

print("a :", a, "\n")
print(f"a['a'] : {a['a']}")
print(f"a['def'] : {a['def']}")
print("a['def'] : {0}".format(a['def']))

del a["a"]
print("a :", a, "\n")

print("a.keys() : ", a.keys(), "\n")

for k in a.keys():  # key list 출력
  print(k)

list_akeys = list(a.keys())  # 리스트로 변환
print("list_akeys :", list_akeys)

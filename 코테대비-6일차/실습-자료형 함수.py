s1 = set([1, 2, 3, 4, 5, 6])
s2 = set([4, 5, 6, 7, 8, 9])
print(s1 & s2, s1.intersection(s2))  # 교집합
print(s1 | s2, s1.union(s2))  # 합집합
print(s1 - s2, s1.difference(s2))  # 차집합

s1.add(7)  # 1개 요소 추가 []없이
s1.remove("a")  # 제거
s1.update(["a", "b", "c"])  # 여러개추가 []리스트 형태로

print(s1)

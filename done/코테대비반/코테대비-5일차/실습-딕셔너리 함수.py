a = {'a': 20, 'name': 'Kevin', 'f': "abc"}
print(a)

print(a["name"])
print(a.get("birth"))  # 해당 키가 없으면 "None"출력

print(a.keys())  # key 값만 추출
print(a.values())  # value 값만 추출

for k in a.keys():
  print(k)

for k in a.values():
  print(k)


a.clear()  # a 딕셔너리 모두 삭제

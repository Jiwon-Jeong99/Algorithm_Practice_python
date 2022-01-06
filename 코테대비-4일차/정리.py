# a = [1,2,3,4,5]
#인덱싱 a[0] = 1
#슬라이싱 a[:2] = [1,2]
#더하기 a+b 반복 a*3
#길이 len(a)
#자료형 int(a) str(a)
#값 수정 a[2] = 4
#값 삭제 del a[2]

#뒤에 추가 a.append(값)
#정렬 a.sort()
#뒤집기 a.reverse()
#위치반환 a.index(값)
#위치삽입 a.insert(위치, 값)
#제거 a.remove(값) - 처음나오는값
#요소추출 a.pop() - 마지막값
#요소추출 a.pop(위치)
#값개수검색 a.count(값)
#리스트확장/추가 a.extend(리스트)


a = [1, 2, 3]
a.extend([4, 5])
print(a)
b = [[6, 7]]
a.extend(b)
print(a)

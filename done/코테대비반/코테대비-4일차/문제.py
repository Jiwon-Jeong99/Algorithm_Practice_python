#빈 리스트 출력
numbers = []
print(numbers)

#리스트에 인덱스 추가
numbers.append(1)
numbers.extend([7, 3, 6, 5, 2, 13, 14])
print(numbers)

#홀수 제거
i = 0
while i < len(numbers):
  print("i : ", i)
  print("len(numbers) : ", len(numbers))
  print("numbers : ", numbers)
  if numbers[i] % 2 == 1:
    del numbers[i]
  else:
    i += 1


#0번째 인덱스에 20 추가
numbers.insert(0, 20)
print(numbers)

#리스트 정렬
numbers.sort()
print(numbers)

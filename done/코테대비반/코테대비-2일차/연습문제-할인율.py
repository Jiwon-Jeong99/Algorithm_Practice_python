thing = int(input("몇 개를 구매하십니까?: "))

if thing < 10:
  print(thing*100, "원입니다")
elif 10 <= thing < 30:
  print(thing*95, "원입니다")
elif 30 <= thing < 100:
  print(thing*85, "원입니다")
else:
  print("상품개수를 다시 입력해주세요(0~100)")

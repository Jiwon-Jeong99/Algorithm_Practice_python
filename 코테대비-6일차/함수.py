def say_nick(nick):
  if nick == "바보":
    #아무것도 없는 걸 return
    return
  print("나의 별명은 %s 입니다" % nick)


say_nick("야호")
say_nick("바보")

#아무것도 안쓰면 기본값 설정된 것으로 인식
#(),[]는 False로 인식

a = 1


def vartest():
  global a
  a += 1


vartest()
print(a)

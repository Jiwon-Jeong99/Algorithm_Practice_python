money = 2000
card = True
if money >= 3000 or card:
  print("택시를 타고 가라")
else:
  print("걸어가라")

pocket = ['papaer', 'cellphone', 'money']
if 'money' in pocket:
  print("택시를 타고 가라")
else:
  print("걸어가라")

pocket = ['paper', 'handphone']
card = True
if 'moeny' in pocket:
  print("택시를 타고가라")
else:
  if card:
    print("택시를 타고 가라")
  else:
    print("걸어가라")

pocket = ['paper', 'cellphone']
card = True
if 'money' in pocket:
  print("택시를 타고 가라")
elif card:
  print("택시를 타고 가라")
else:
  print("걸어 가라")

money = input()
if int(money) > 3000:
  print("택시")
else:
  print("걸어가")

id = input("아이디:")
pw = input("비밀번호:")
if id == 'admin' and pw == '1234':
  print("로그인 되었습니다.")
elif id == 'admin' and pw != '1234':
  print("비밀번호가 틀렸습니다.")
else:
  print("아이디가 없습니다.")

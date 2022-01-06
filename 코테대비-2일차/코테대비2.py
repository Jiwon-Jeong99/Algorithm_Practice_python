print('나는 대한민국 "사람"입니다')
print("나는 대한민국 '사람'입니다")

head = "Python"
tail = " is fun!"
print(head + tail)

a = "Python"
print(a*2, "\n")

a = "Life is too short"
print(len(a), "\n")  # 문자열 길이

a = "Life is too short, You need Python"
print(a[3], "\n")
print("a[-1]의 위치값 : ", a[-1])
b = a[0]+a[1]+a[2]+a[3]
print("더하는 방법", b)
print("슬라이싱", a[0:4])

c = "20010331Rainy"
year = c[:4]
day = c[4:8]
weather = c[8:]
print(year)
print(day)
print(weather, "\n")

a = "Pithon"
print(a[:1]+'y'+a[2:], "\n")

g = "I eat %d apples."
print(g % 3)
h = "I eat %s apples."
print(h % 'five', "\n")

number = 19
day = "three"
f = "I ate %d apples, so I was sick for %s days."
print(f % (number, day), "\n")

e = "Error is %d%%"
print(e % 98, "\n")

number = 10
day = "three"
a = "I ate {0} apples, so I was sick for {1} days."
print(a.format(number, day))

b = "I ate {number} apples, so I was sick for {day} days."
print(b.format(number=10, day='three'), "\n")

c = "I ate {0} apples, so I was sick for {days} days."
print(c.format(10, days=3))

age = 30
sen = f"나는 내년이면 {age+1}살이 된다."
print(sen)
#f 붙여주면 변수 지정한 것중 알아서 해당 변수명을 가져와서 붙여줌

w = {'name': '홍길동', 'age': 30}
z = f'나의 이름은 {w["name"]}입니다. 나이는 {w["age"]}입니다.'
print(z)

w = "123"
y = "공백확인"
print(y, w, y)
#무조건 한칸 공백 생김
print(y+w+y)
#공백이 생기지 않음

slt = "Life is too short"
print(slt.split())
n = slt.split()
print(n[2])

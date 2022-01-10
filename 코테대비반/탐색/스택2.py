a =[]
for i in range(100):
    a.append(i+1)

print(a)

print(a[0:10:2]) #처음,끝,간격 10까지만 홀수 출력
print(a[::2]) #전체 홀수만 출력
print(a[1::2]) #전체 짝수만 출력
print(a[-1:-100:-2])
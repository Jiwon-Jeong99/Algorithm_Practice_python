a = int(input())

for i in range(1, a+1):
    if i%3 == 0:
        continue 
    #continue하면 반복문 안의 나머지 부분은 실행x, 다음 반복 단계로 넘어감(a+1)
    print(i, end=' ')
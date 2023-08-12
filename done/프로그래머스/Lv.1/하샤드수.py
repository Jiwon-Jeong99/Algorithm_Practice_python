#1
def solution(x):
    # int의 각자리를 리스트에 넣으려면 str로 형변환이 필요
    y = list(str(x)) 
    sum = 0
    for i in range(len(y)):
        sum += int(y[i])

        if x % sum == 0:
            answer = True
        else:
            answer = False
    return answer

#2


def Harshad(n):
    # n은 하샤드 수 인가요?
    st = str(n)
    a = 0
    for i in range(len(st)):
        a += int(st[i])

    return True if n % a == 0 else False

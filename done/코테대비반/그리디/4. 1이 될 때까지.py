N, K = map(int, input().split()) #map함수는 안의 요소를 전부 int로 바꿔줌 (str일 경우 문자열로)

count  = 0

def calculate():
    global N
    global count
    while N > 1:
        if N % K == 0:
            N = N // K
            count += 1
        else :
            N = N - 1
            count += 1

calculate()

print(count)



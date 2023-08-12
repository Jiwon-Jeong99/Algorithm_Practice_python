s = input()

# s의 인덱스 0부터 a의 개수만큼의 문자열 중 b의 개수만큼 교환해야 됨
num_a = s.count('a')

# max나 min 배열에 넣지 않고 한번에 비교하기 - 큰 수 대입
Min = 99999999999999999

for i in range(len(s)):
    count = 0
    for j in range(i, i + num_a):
        over = j
        #j의 인덱스가 마지막보다 커지면 - solution 2
        if j >= len(s):
            over = j - len(s)
        if s[over] == 'b':
            count += 1
    # max나 min 배열에 넣지 않고 한번에 비교하기 - 비교
    Min = min(Min, count)

print(Min)

s = input()

# s의 인덱스 0부터 a의 개수만큼의 문자열 중 b의 개수만큼 교환해야 됨
num_a = s.count('a')
Min = 99999999999999999

for i in range(len(s)):
    count = 0
    for j in range(i, i + num_a):
        over = j
        if j >= len(s):
            over = j - len(s)
        if s[over] == 'b':
            count += 1
        
    Min = min(Min, count)

print(Min)

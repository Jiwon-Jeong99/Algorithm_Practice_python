import sys

s = sys.stdin.readline().rstrip()

# for문을 통해 문자열을 비교(브루트포스)
for i in range(len(s)):

    # i번째~끝까지 문자열 & i번째~끝까지를 역순으로 확인한 문자열을 비교
    # 같을 경우(팰린드롬 가능성) 문자열 뒤에 i만큼 추가해주면 됨
    if s[i:] == s[i:][::-1]:
        print(len(s) + i)
        break
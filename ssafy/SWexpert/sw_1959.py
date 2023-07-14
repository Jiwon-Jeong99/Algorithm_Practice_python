"""
1. n.m의 길이를 파악
2. n,m 비교, 총 이동가능 횟수 알아내기
3. 총합을 비교하면서 큰 값을 반환
"""

test_case = int(input())

# 짧은 길이의 리스트가 움직일 횟수 (큰값-작은값)+1 => 총 움직일 횟수
def compare(n, m):
    if n > m:
        return (n-m+1, m)
    elif n < m:
        return (m-n+1, n)
    else:
        return (1, m)

for i in range(test_case):
    n, m = map(int, input().split())
    n_list = list(map(int, input().split()))
    m_list = list(map(int, input().split()))

    play, short = compare(n, m)

    # 최댓값
    max_sum = []
    for k in range(play):
        sum = 0
        for j in range(short):
            if short == m:
                sum += (n_list[j+k]) * (m_list[j])
            elif short == n:
                sum += (n_list[j]) * (m_list[j+k])
        max_sum.append(sum)

    ans = max(max_sum)
    print("#%d" % (i+1), ans)


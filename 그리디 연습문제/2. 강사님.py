#의사코드
#입력
#배열에서 가장 큰 수 2개 x,y
#m(전체계산횟수, k제한적횟수)

#합계 all_sum
#반복 m
# - 조건 x를 k횟수 더한다.
# -      y를 1회 더한다.

n, m, k = map(int, input().split())
data = list(map(int, input().split()))
#n,m,k,data = 5,8,3,[2,4,5,4,6]
print(data)

data.sort()

x = data[-1]  # 가장 큰 수
y = data[-2]  # 두번째 큰 수
n_count = 0  # 총 횟수 카운팅 용
all_sum = 0  # 전체 합계

temp = []

while m > 0:  # m횟수 차감
  m -= 1
  if n_count < k:
    all_sum += x
    n_count += 1

    temp.append(x)
    print("[x] n_count :", n_count)
    print("[x] all_sum :", all_sum)
    print("[x] temp :", x)
  else:
    all_sum += y
    n_count = 0

    temp.append(y)
    print("[y] n_count :", n_count)
    print("[y] temp :", y)

print(all_sum)
print(temp)

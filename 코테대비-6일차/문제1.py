#1. 주어진 자연수가 홀수인지 짝수인지 판별하는 함수를 만들어라

a = int(input("자연수를 입력하세요 : "))


def odd(a):
  if a % 2 == 0:
    result = "짝수"
  else:
    result = "홀수"
  return result


print(odd(a))

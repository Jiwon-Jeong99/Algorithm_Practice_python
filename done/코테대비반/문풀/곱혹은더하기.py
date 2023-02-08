import sys

n = sys.stdin.readline()
#여기서는 int 안됨 왜냐면 0 이 빠짐
result=0


for i in range(int(len(n))-1):
  print("i :",i,n[i])

  if i == 0:
    result = int(n[i])
    print("result = n[i] :",result,n[i])
    continue

  if int(n[i]) <= 1 or result <= 1: 
      #1하고 같이 있을때는 더하는게 더 큼
    result += int(n[i])
    print("덧셈 :",result,"+=",i,int(n[i]))
  else:
    result *= int(n[i])
    print("곱셈 :",result,"*=",i,int(n[i]))

print(result)


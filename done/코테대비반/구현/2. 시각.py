'''
#1 
문자열로 n을 받아서
초를 1씩 더해서 60이 되면 분으로 넘어가고
분이 60이 되면 시로 넘어가서
시가 0에서 n까지 하나의 문자열 054647
이런식으로 되는데
이때 if '3' in time: count += 1

'''
n = int(input())

count = 0
for h in range(n+1):
  for m in range(60):
    for s in range(60):
      f_time = str(h)+":"+str(m)+":"+str(s)
      if "3" in f_time:
        print("f_time :",f_time)
        count += 1

print(count)

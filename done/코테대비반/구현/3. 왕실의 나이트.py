
g = input()
count = 0

dic_change = {"a":1,"b":2,"c":3,"d":4,"e":5,"f":6,"g":7,"h":8}
x,y = dic_change[g[0]],int(g[1])

move_root = [(2,1),(1,2),(-1,2),(-2,1),(-2,-1),(-1,-2),(1,-2),(2,-1)]

for i in move_root:
  print(i)
  x_d = x + i[0]
  y_d = y + i[1]
  print("[chk] x_d,y_d : ",x_d,y_d)
  if x_d >= 1 and x_d <= 8 and y_d >= 1 and y_d <= 8:
    count += 1
    print("count += :",count,"\n")

print (count)

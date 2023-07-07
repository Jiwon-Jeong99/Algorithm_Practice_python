a, b = map(int, input().split())

if a == 1 and b == 2:
    print('B')
elif a == 1 and b == 3:
    print('A')
elif a == 2 and b == 1:
    print('A')
elif a == 2 and b == 3:
    print('B')
elif a == 3 and b == 1:
    print('B')
else:
    print('A')

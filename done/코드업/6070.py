import sys

month = int(sys.stdin.readline())

if month == 12 or month==1 or month==2:
    print('winter')
elif month//3==1:
    print('spring')
elif month//3==2:
    print('summer')
else:
    print('fall')
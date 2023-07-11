test_case = int(input())

def detect(n, str):
    if n % 2 != 0:
        return "No"
    elif n % 2 == 0 and str[:n//2] == str[n//2:]:
        return "Yes"
    else:
        return "No"

for i in range(test_case):
    n = int(input())
    str = input()

    ans = detect(n, str)

    print("#%d" % (i+1), ans)

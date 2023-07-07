test_case = int(input())
for i in range(test_case):
    n_list = list(map(int, input().split()))
    odd_list = []
    for num in n_list:
        if num % 2 == 1:
            odd_list.append(num)
        else:
            continue
    sumNum = sum(odd_list)
    print("#%d %d" % (i+1, sumNum))
